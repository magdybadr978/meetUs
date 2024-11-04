package com.example.app.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.app.model.product.Product;
import com.example.app.model.product.ProductRepository;



@Service
public class ProductService {
  private final ProductRepository productRepository;
  
  @Autowired
  public ProductService(ProductRepository productRepository){
    this.productRepository = productRepository;
  }

  //Create product
  public Product createProduct(Product product){
    return productRepository.create(product);
  }

  // get specific product by id 
   public Optional<Product> getProductById(Long id) {
    // check if product exist
    Optional<Product> productExist = productRepository.findOne(id);
    //failed
    if(productExist.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Product not exist");
    }
        // send response
        return productExist;
    }


    // get all products
    public Page<Product> getAllProducts(int page, int size, String sortBy) {
        // make pagination and sorting
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        // send response
        return productRepository.findAll(pageable);
    }

    // update product by id
    public Product updateProduct(Long id, Product product) {
      // check if product exist
      Optional<Product> productExist = productRepository.findOne(id);
      //failed
      if(productExist.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Product not exist");
    }
        // set my id
        product.setId(id);
        // send response
        return productRepository.update(product);
    }

    // delete product by id 
    public void deleteProduct(Long id) {
      // check if product exist
    Optional<Product> productExist = productRepository.findOne(id);
    //failed
    if(productExist.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Product not exist");
    }
        // send response
        productRepository.deleteOne(id);
    }



}
