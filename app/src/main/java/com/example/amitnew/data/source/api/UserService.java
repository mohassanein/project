package com.example.amitnew.data.source.api;

import com.example.amitnew.data.model.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    //function post send in body with relative url
    @POST("api/register")
    // class call type String            //map key:string and Value: string & map name is user
    Call<UserResponse>UserRegisteration(@Body Map<String,String>user);

    @POST("api/login")
    Call<UserResponse>UserLogin(@Body Map<String,String>loged);


}
