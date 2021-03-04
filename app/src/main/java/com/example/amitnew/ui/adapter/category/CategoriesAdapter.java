package com.example.amitnew.ui.adapter.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.amitnew.R;
import com.example.amitnew.data.model.category.CategoriesItem;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.categoriesHolder> {

        private List<CategoriesItem>category = new ArrayList<>();
    private Context context;

    public CategoriesAdapter(Context context) {
        this.context = context;
    }

    public void setCategory(List<CategoriesItem> category) {
        this.category = category;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public categoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_items,parent,false);

        return new categoriesHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull categoriesHolder holder, int position) {

        CategoriesItem categ = category.get(position);
        if (categ!= null) {
            Glide.with(context).load(categ.getAvatar()).into(holder.categ_image);
            holder.categ_name.setText(categ.getName());

        }

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    static class categoriesHolder extends RecyclerView.ViewHolder {

        ImageView categ_image;
        TextView categ_name;
        public categoriesHolder(@NonNull View itemView) {
            super(itemView);

            categ_image= itemView.findViewById(R.id.category_image);
            categ_name= itemView.findViewById(R.id.category_type);
        }
    }















}
