package com.example.amitnew.data.source.api;

import com.example.amitnew.data.model.AddCartResponse;
import com.example.amitnew.data.model.category.CategoryResponse;
import com.example.amitnew.data.model.product.ProudctsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductService {


    @GET("api/products")
    Call<ProudctsResponse>getAllproducts();


    @GET("api/categories")
    Call<CategoryResponse>getAllCategories();

    @PUT("api/user/products/{id}")
    Call<AddCartResponse>AddProductToCart(@Path("id") int id, @Header("Authorization") String token, @Query("amount") int amount);


}
