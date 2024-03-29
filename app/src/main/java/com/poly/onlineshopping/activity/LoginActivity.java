package com.poly.onlineshopping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.poly.onlineshopping.MainActivity;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.SanPham;
import com.poly.onlineshopping.model.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    EditText ed_email_login,ed_pass_login;
    Button btn_login;
    TextView tv_dangky_login;
    ProgressBar progressBar;

    List<Users> usersList;
    String token = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_email_login = findViewById(R.id.ed_email_login);
        ed_pass_login = findViewById(R.id.ed_password_login);
        btn_login = findViewById(R.id.btn_login);
        tv_dangky_login = findViewById(R.id.tv_dangky_login);
         progressBar = (ProgressBar) findViewById(R.id.progressbar_sign_in);
        Sprite doubleBounce = new Circle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.GONE);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed_email_login.getText().toString().trim();
                String password = ed_pass_login.getText().toString().trim();
                if (email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                getData(email,password);
            }
        });
        tv_dangky_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getData(String email,String password) {
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Users user = new Users(email,password,null);
        Call<Users> call = apiService.postLogin(user);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()){
                    Users userApi = response.body();
                    token = userApi.getToken();
                    if (token !=null){
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE);
                        finishAffinity();
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }
                    SharedPreferences sp= getSharedPreferences("Login", MODE_PRIVATE);
                    SharedPreferences.Editor Ed= sp.edit();
                    Ed.putString("email",userApi.getEmail() );
                    Ed.putString("id",userApi.get_id());
//                    Ed.putString("sodienthoai",userApi.getSodienthoai());
//                    Ed.putString("diachi",userApi.getDiachi());
                    Ed.putString("token",userApi.getToken());
                    Ed.commit();

                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Lỗi api", Toast.LENGTH_SHORT).show();
            }
        });
    }
}