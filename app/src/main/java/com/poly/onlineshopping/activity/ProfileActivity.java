package com.poly.onlineshopping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.poly.onlineshopping.R;
import com.poly.onlineshopping.api.ApiService;
import com.poly.onlineshopping.model.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {
    EditText ed_mail_thaydoi, ed_sdt_thaydoi, ed_diachi_thaydoi, ed_hoTen_thaydoi;
    Toolbar toolbar;
    Button btn_thaydoi;
    ProgressDialog progressDialog;
    String token;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = findViewById(R.id.toolbar_thaydoi);
        ed_mail_thaydoi = findViewById(R.id.ed_mail_thaydoi);
        ed_sdt_thaydoi = findViewById(R.id.ed_sdt_thaydoi);
        ed_diachi_thaydoi = findViewById(R.id.ed_diachi_thaydoi);
        ed_hoTen_thaydoi = findViewById(R.id.ed_hoTen_thaydoi);
        btn_thaydoi = findViewById(R.id.btn_thaydoi);
        progressDialog =new ProgressDialog(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar = (ProgressBar) findViewById(R.id.progressbar_doithongtin);
        Sprite doubleBounce = new Circle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.GONE);

        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        token = sp1.getString("token","");

        getProfile();

        btn_thaydoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_hoTen_thaydoi.getText().toString().trim();
                String email = ed_mail_thaydoi.getText().toString().trim();
                String sdt = ed_sdt_thaydoi.getText().toString().trim();
                String diachi = ed_diachi_thaydoi.getText().toString().trim();
                progressBar.setVisibility(View.VISIBLE);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://adminshop68.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
                Log.e("aa","id"+token);
                Users users = new Users(name,email,sdt,diachi);
                Call<Users> call = apiService.postEditUser(token,users);
                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if (response.isSuccessful())
                        {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(ProfileActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        }else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(ProfileActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {

                    }
                });
            }
        });
    }
    private void getProfile() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://adminshop68.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Users> call = apiService.getProfile(token);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()){
                    ed_hoTen_thaydoi.setText(response.body().getTen());
                    ed_mail_thaydoi.setText(response.body().getEmail());
                    ed_sdt_thaydoi.setText(response.body().getSodienthoai());
                    ed_diachi_thaydoi.setText(response.body().getDiachi());
                }else {
                    Toast.makeText(ProfileActivity.this, "not connect", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}