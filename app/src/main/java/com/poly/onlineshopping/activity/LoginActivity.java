package com.poly.onlineshopping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.poly.onlineshopping.MainActivity;
import com.poly.onlineshopping.R;

import java.io.BufferedReader;

public class LoginActivity extends AppCompatActivity {

    EditText ed_email_login,ed_pass_login;
    Button btn_login;
    TextView tv_dangky_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_email_login = findViewById(R.id.ed_email_login);
        ed_pass_login = findViewById(R.id.ed_password_login);
        btn_login = findViewById(R.id.btn_login);
        tv_dangky_login = findViewById(R.id.tv_dangky_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
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
}