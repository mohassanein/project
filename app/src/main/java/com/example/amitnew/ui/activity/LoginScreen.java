package com.example.amitnew.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amitnew.R;
import com.example.amitnew.data.source.api.ApiManager;
import com.example.amitnew.data.model.UserResponse;
import com.example.amitnew.helper.TokenManager;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity {
EditText logmail,logpassword;
TextView sign;
Button log_in;
    TokenManager tokenManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
   intivew();

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              login();

            }
        });

   sign.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent in = new Intent(LoginScreen.this, SignUpScreen.class);
           startActivity(in);
           finish();
       }
   });
    }

    protected void intivew(){
        sign=findViewById(R.id.go_Signup);
        log_in = findViewById(R.id.login_btn);
        logmail = findViewById(R.id.mail_login);
        logpassword = findViewById(R.id.password_login);
        tokenManager = new TokenManager(this);
    }

    protected void login() {

        String Pass = logpassword.getText().toString().trim();
        String Email = logmail.getText().toString().trim();
        if (Pass.equals("") || Email.equals("")) {
            Toast.makeText(this, "check your Data", Toast.LENGTH_LONG)
                    .show();
        } else {

            Map<String, String> loged = new HashMap<>();
            loged.put("email", Email);
            loged.put("password", Pass);

            ApiManager.getUserService().UserLogin(loged).enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    if(response.isSuccessful()) {
                        tokenManager.saveToken(response.body().getToken());
                        Intent in = new Intent(LoginScreen.this, EcommerceAmit.class);
                        startActivity(in);
                        finish();
                        Log.d("ddddd", "onResponse: "+ response.body().getToken());
                    }
                    else Toast.makeText(LoginScreen.this,"Wrong email or password",Toast.LENGTH_LONG)
                            .show();
                    Log.d("ddddd", "onResponse: "+ response.code()+ response.message());
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
            Toast.makeText(LoginScreen.this,"Registration Failed",Toast.LENGTH_LONG)
                            .show();
                }
            });

        }
    }
}