package com.example.amitnew.data.reprository;

import androidx.lifecycle.MutableLiveData;

import com.example.amitnew.data.model.product.ProductsItem;
import com.example.amitnew.data.model.product.ProudctsResponse;
import com.example.amitnew.data.source.api.ApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductReprository {
    private MutableLiveData<List<ProductsItem>>productsLiveData;
    private MutableLiveData<String>messageLiveData;

    public ProductReprository() {
        productsLiveData = new MutableLiveData<>();
        messageLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<ProductsItem>> getProductsLiveData() {
        return productsLiveData;
    }

    public MutableLiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    public void getAllproducts(){

        ApiManager.getProductService().getAllproducts().enqueue(new Callback<ProudctsResponse>() {
            @Override
            public void onResponse(Call<ProudctsResponse> call, Response<ProudctsResponse> response) {
                if(response.isSuccessful()){

                   productsLiveData.setValue(response.body().getProducts());

                }
            }

            @Override
            public void onFailure(Call<ProudctsResponse> call, Throwable t) {
                messageLiveData.setValue(t.getLocalizedMessage());
            }
        });



    }

}
