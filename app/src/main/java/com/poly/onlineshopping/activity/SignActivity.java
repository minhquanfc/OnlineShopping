package com.poly.onlineshopping.activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.onlineshopping.R;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.Users;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignActivity extends AppCompatActivity {

    EditText ed_hoten_signin,ed_email_signin,ed_password_signin,ed_sdt_signin,ed_diachi_signin;
    Button btn_signin;
    TextView tv_dangnhap_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        ed_hoten_signin = findViewById(R.id.ed_hoten_signin);
        ed_email_signin = findViewById(R.id.ed_email_signin);
        ed_password_signin = findViewById(R.id.ed_password_signin);
        ed_sdt_signin = findViewById(R.id.ed_sdt_signin);
        ed_diachi_signin = findViewById(R.id.ed_diachi_signin);
        btn_signin = findViewById(R.id.btn_signin);
        tv_dangnhap_signin = findViewById(R.id.tv_dangnhap_signin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = ed_hoten_signin.getText().toString();
                String email = ed_email_signin.getText().toString().trim();
                String pass = ed_password_signin.getText().toString().trim();
                String sdt = ed_sdt_signin.getText().toString();
                String diachi = ed_diachi_signin.getText().toString();
                if (ten.isEmpty() || email.isEmpty() || pass.isEmpty() || sdt.isEmpty() || diachi.isEmpty()){
                    Toast.makeText(SignActivity.this, "Vui lòng điền thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }else if (!validateEmail(email)){
                    Toast.makeText(SignActivity.this, "Vui lòng nhập đúng định dạng email", Toast.LENGTH_SHORT).show();
                    return;
                } else if (pass.length()<6){
                    Toast.makeText(SignActivity.this, "Mật khẩu phải dài hơn 6 ký tự", Toast.LENGTH_SHORT).show();
                    return;
                }
                postReg(ten,email,pass,sdt,diachi);
            }
        });

        tv_dangnhap_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private void postReg(String ten,String email,String password,String sodienthoai,String diachi) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.243:3000/api/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Users user = new Users(ten,email,password,sodienthoai,diachi);
        Call<Users> call = apiService.createPost(user);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()){
                    ed_hoten_signin.setText("");
                    ed_email_signin.setText("");
                    ed_password_signin.setText("");
                    ed_diachi_signin.setText("");
                    ed_sdt_signin.setText("");
                    Users responseFromAPI = response.body();
                    Toast.makeText(SignActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignActivity.this,LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignActivity.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(SignActivity.this, "Lỗi api", Toast.LENGTH_SHORT).show();
            }
        });
    }
}