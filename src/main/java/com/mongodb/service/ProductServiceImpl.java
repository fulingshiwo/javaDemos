package com.mongodb.service;

import com.mongodb.dao.ProductDao;
import com.mongodb.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ChenQuan on 2017/5/27.
 */
@Service("productService")
public class ProductServiceImpl  implements ProductService{

    @Autowired
    private ProductDao productDao;
    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }
}
