package com.timesinternet.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.timesinternet.crud.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	Product findByName(String Name);

}
