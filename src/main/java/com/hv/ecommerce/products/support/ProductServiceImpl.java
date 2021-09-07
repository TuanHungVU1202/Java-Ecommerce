package com.hv.ecommerce.products.support;

import com.hv.ecommerce.products.Product;
import com.hv.ecommerce.products.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> addProducts(List<ProductDTO> productDTOS) {
        //TODO: finish this method for the controller

        return null;
    }
}
