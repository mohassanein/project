package com.example.amitnew.ui.fragments.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.amitnew.data.model.category.CategoriesItem;
import com.example.amitnew.data.reprository.CategoriesReprository;

import java.util.List;

public class CategoryViewModel extends ViewModel {
    private LiveData<List<CategoriesItem>>CategoriesLiveData;
    private LiveData<String> messageLiveData ;

    public LiveData<List<CategoriesItem>> getCategoriesLiveData() {
        return CategoriesLiveData;
    }

    public LiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    private CategoriesReprository reprository = new CategoriesReprository();

    public void getCategories(){
        reprository.getAllCategories();
        CategoriesLiveData = reprository.getCategoryLiveData();
        messageLiveData = reprository.getMessageLiveData();
    }


}
