package com.example.amitnew.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.amitnew.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ink = new Intent(SplashScreen.this, LoginScreen.class);
                startActivity(ink);
                finish();
            }
        },3000);
        Toast.makeText(this,"Welcome to Ecomerce",Toast.LENGTH_LONG)
                .show();
    }
}