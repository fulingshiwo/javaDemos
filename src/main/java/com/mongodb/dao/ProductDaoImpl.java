package com.mongodb.dao;

import com.mongodb.common.MongoGenDao;
import com.mongodb.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ChenQuan on 2017/5/27.
 */
@Repository("productDao")
public class ProductDaoImpl  implements  ProductDao{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveProduct(Product product) {
        this.mongoTemplate.save(product);
    }

}
