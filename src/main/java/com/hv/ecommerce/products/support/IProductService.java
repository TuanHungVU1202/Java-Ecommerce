package com.hv.ecommerce.products.support;


import com.hv.ecommerce.products.Product;
import com.hv.ecommerce.products.ProductDTO;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    List<Product> addProducts(List<ProductDTO> productDTOS);
}
