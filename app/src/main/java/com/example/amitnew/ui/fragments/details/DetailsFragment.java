package com.example.amitnew.ui.fragments.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.amitnew.R;
import com.example.amitnew.data.model.product.ProductsItem;

public class DetailsFragment extends Fragment {

    ProductsItem product;
    ImageView image_details;
    TextView  item_details,title_details,price_final,product_count,desc_details;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            product = (ProductsItem) getArguments().getSerializable("product");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        image_details = view.findViewById(R.id.image_details);
        Glide.with(getContext()).load(product.getAvatar()).into(image_details);
        item_details = view.findViewById(R.id.item_details);
        title_details = view.findViewById(R.id.title_details);
        price_final = view.findViewById(R.id.price_final);
        product_count = view.findViewById(R.id.product_count);
        desc_details = view.findViewById(R.id.desc_details);
        item_details.setText(product.getName());
        title_details.setText(product.getTitle());
        price_final.setText(String.valueOf(product.getPriceFinal()));
       // product_count.setText(product.getInStock());
        desc_details.setText(product.getDescription());

    }




}