package com.myapp.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.demo.model.Product;
import com.myapp.demo.repo.ProductRepository;

@RestController  //rest api
public class ProductApi {
	
	@Autowired  //depency object // we need an object container to  inject
	
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products=productRepository.findAll();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> save(Product product){
		productRepository.save(product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}

}
