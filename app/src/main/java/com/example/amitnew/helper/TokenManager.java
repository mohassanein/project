package com.example.amitnew.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenManager {

    private SharedPreferences shared;

    public TokenManager(Context context) {

        shared = context.getSharedPreferences("token",context.MODE_PRIVATE);
    }

    public void saveToken(String token){

        SharedPreferences.Editor editor =  shared.edit();
        editor.putString("token",token);
        editor.apply();
    }

    public String getToken(){

      return  shared.getString("token",null);


    }

}
