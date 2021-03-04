package com.example.amitnew.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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

public class SignUpScreen extends AppCompatActivity {
    EditText name,pass,email;
    Button signUp_btn;
    TextView go_login;
    LinearLayout layout;
    ProgressBar progressBar;
    TokenManager tokenManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiview();


        go_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SignUpScreen.this, LoginScreen.class);
                startActivity(in);
                finish();
            }
        });
        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    protected void intiview(){
        name=findViewById(R.id.user_name);
        pass=findViewById(R.id.password);
        email=findViewById(R.id.mail);
        signUp_btn = findViewById(R.id.signUp_btn);
        go_login=findViewById(R.id.go_login);
        layout=findViewById(R.id.parent_layout);
        progressBar=findViewById(R.id.progress_icon);
        tokenManager = new TokenManager(this);

    }

    protected void Register(){
        String Name = name.getText().toString().trim();
        String Pass = pass.getText().toString().trim();
        String Email = email.getText().toString().trim();
        if(Name.equals("")||Pass.equals("")||Email.equals(""))
        {
            Toast.makeText(this,"check your Data",Toast.LENGTH_LONG)
                    .show();
        }
        else
        {

            progressBar.setVisibility(View.VISIBLE);
            layout.setVisibility(View.GONE);

            Map<String,String>user= new HashMap<>();
            user.put("name", Name);
            user.put("email", Email);
            user.put("password", Pass);
           ApiManager.getUserService().UserRegisteration(user).enqueue(new Callback<UserResponse>() {
               @Override
               public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                   if (response.isSuccessful()) {
                       tokenManager.saveToken(response.body().getToken());
                       Toast.makeText(SignUpScreen.this, "Registration Success", Toast.LENGTH_SHORT)
                               .show();
                       progressBar.setVisibility(View.VISIBLE);
                       layout.setVisibility(View.GONE);
                       Intent in = new Intent(SignUpScreen.this, EcommerceAmit.class);
                       startActivity(in);
                       finish();
                       Log.d("ddddd", "onResponse: "+ response.code() + response.body());
                   }
                   else
                       {
                       progressBar.setVisibility(View.INVISIBLE);
                       layout.setVisibility(View.VISIBLE);
                       Toast.makeText(SignUpScreen.this, "User Exists Go Login", Toast.LENGTH_SHORT)
                               .show();
                       Intent in = new Intent(SignUpScreen.this, SignUpScreen.class);
                       startActivity(in);
                       Log.d("ddddd", "onResponse: "+ response.code()+response.body());
                   }
               }




               @Override
               public void onFailure(Call<UserResponse> call, Throwable t) {
                   progressBar.setVisibility(View.GONE);
                   layout.setVisibility(View.VISIBLE);
                   Toast.makeText(SignUpScreen.this,"Registration Failed",Toast.LENGTH_SHORT)
                           .show();
                   Log.d("dddd", "onFailure: " +t.getLocalizedMessage());
               }
           });

        }
    }
}