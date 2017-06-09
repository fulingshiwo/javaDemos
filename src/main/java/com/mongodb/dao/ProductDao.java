package com.mongodb.dao;

import com.mongodb.entity.Product;

/**
 * Created by ChenQuan on 2017/5/27.
 */
public interface ProductDao {

    /**
     * 插入数据
     */
    public void saveProduct(Product product);
}
