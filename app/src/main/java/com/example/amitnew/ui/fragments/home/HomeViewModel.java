package com.example.amitnew.ui.fragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.amitnew.data.model.AddCartResponse;
import com.example.amitnew.data.model.product.ProductsItem;
import com.example.amitnew.data.reprository.ProductReprository;
import com.example.amitnew.data.source.api.ApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel  extends ViewModel {

    private LiveData<List<ProductsItem>> productsLiveData ;
    private LiveData<String> messageLiveData ;

    public LiveData<List<ProductsItem>> getProductsLiveData() {
        return productsLiveData;
    }

    public LiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    private  ProductReprository reprository = new ProductReprository();

    public void getProducts(){
    reprository.getAllproducts();
    productsLiveData = reprository.getProductsLiveData();
    messageLiveData = reprository.getMessageLiveData();
    }

    private MutableLiveData<String> addCartResponseMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String>messageAddCartLiveData = new MutableLiveData<>();



    public MutableLiveData<String> getAddCartResponseMutableLiveData() {
        return addCartResponseMutableLiveData;
    }

    public MutableLiveData<String> getMessageAddCartLiveData() {
        return messageAddCartLiveData;
    }

    public void addProductsToCart(int id, String token, int amount){

        ApiManager.getProductService().AddProductToCart(id,"Bearer "+token,1).enqueue(new Callback<AddCartResponse>() {
            @Override
            public void onResponse(Call<AddCartResponse> call, Response<AddCartResponse> response) {
                if(response.isSuccessful())
                    addCartResponseMutableLiveData.setValue(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<AddCartResponse> call, Throwable t) {
                messageAddCartLiveData.setValue(t.getLocalizedMessage());
            }
        });



    }


}
