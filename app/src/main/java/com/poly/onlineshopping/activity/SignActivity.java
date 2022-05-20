package com.poly.onlineshopping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.poly.onlineshopping.R;

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

        tv_dangnhap_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}