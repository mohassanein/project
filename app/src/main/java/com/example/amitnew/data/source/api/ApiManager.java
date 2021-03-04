package com.example.amitnew.data.source.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {


    private static Retrofit retrofit;
    private static final String BASE_URL = "http://retail.amit-learning.com/";

    private static Retrofit getInstance(){

        if(retrofit==null)
        {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        }
        return retrofit;
    }

    public static UserService getUserService(){

return  getInstance().create(UserService.class);

    }

    public static ProductService getProductService(){


        return getInstance().create(ProductService.class);

    }


}
