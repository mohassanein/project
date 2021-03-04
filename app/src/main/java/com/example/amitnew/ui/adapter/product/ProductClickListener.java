package com.example.amitnew.ui.adapter.product;

import com.example.amitnew.data.model.product.ProductsItem;

public interface ProductClickListener {
    void showProductDetails(ProductsItem product);
    void addProductsToCart(ProductsItem product);
}
