package com.example.amitnew.data.model.product;

import java.util.List;

import com.example.amitnew.data.model.product.ProductsItem;
import com.google.gson.annotations.SerializedName;

public class ProudctsResponse{

	@SerializedName("products")
	private List<ProductsItem> products;

	public List<ProductsItem> getProducts(){
		return products;
	}
}