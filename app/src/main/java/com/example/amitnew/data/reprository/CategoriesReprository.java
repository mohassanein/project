package com.example.amitnew.data.reprository;

import androidx.lifecycle.MutableLiveData;

import com.example.amitnew.data.model.category.CategoriesItem;
import com.example.amitnew.data.model.category.CategoryResponse;
import com.example.amitnew.data.source.api.ApiManager;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesReprository {
    private MutableLiveData<List<CategoriesItem>>categoryLiveData;
    private MutableLiveData<String>messageLiveData;

    public CategoriesReprository() {
       categoryLiveData = new MutableLiveData<>();
       messageLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<CategoriesItem>> getCategoryLiveData() {
        return categoryLiveData;
    }

    public MutableLiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    public void getAllCategories(){
        ApiManager.getProductService().getAllCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if(response.isSuccessful())
                    categoryLiveData.setValue(response.body().getCategories());
                    else
                        messageLiveData.setValue(response.message());


            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                messageLiveData.setValue(t.getLocalizedMessage());
            }
        });



    }


}
