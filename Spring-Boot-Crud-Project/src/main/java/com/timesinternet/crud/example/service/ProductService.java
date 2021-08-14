package com.timesinternet.crud.example.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timesinternet.crud.example.entity.Product;



@Service
public class ProductService {

	@Autowired
	private ProductService repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(int id){
		return repository.findById(id).orElse(null);
	}
	

	public Product getProductByName(String name){
		return repository.findByName(name);
	}
	
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed !! " + id;
	}
	
	
}
