package com.hv.ecommerce.products.support;


import com.hv.ecommerce.products.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
}
