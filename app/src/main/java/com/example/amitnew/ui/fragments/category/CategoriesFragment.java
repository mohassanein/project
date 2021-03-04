package com.example.amitnew.ui.fragments.category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amitnew.data.model.category.CategoriesItem;
import com.example.amitnew.ui.adapter.category.CategoriesAdapter;
import com.example.amitnew.R;

import java.util.List;


public class CategoriesFragment extends Fragment {

    RecyclerView categories_recycler;
    RecyclerView.LayoutManager layoutManager;
    CategoriesAdapter adapter;

   //View model
    private  CategoryViewModel categoryViewModel;

    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycler(view);
        categoryViewModel  = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);
        categoryViewModel.getCategories();
        categoryViewModel.getCategoriesLiveData().observe(requireActivity(), new Observer<List<CategoriesItem>>() {
            @Override
            public void onChanged(List<CategoriesItem> categoriesItems) {
                adapter.setCategory(categoriesItems);
            }
        });

        categoryViewModel.getMessageLiveData().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(),""+s,Toast.LENGTH_LONG).show();
            }
        });


    }

    protected void initRecycler(View v){

        categories_recycler= v.findViewById(R.id.product_recycler_category);
        adapter = new CategoriesAdapter(getContext());
        layoutManager = new GridLayoutManager(getContext(),2);
        categories_recycler.setAdapter(adapter);
        categories_recycler.setLayoutManager(layoutManager);

    }








}