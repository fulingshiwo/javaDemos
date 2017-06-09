package com.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by ChenQuan on 2017/3/15.
 */
@Document(collection="Product")
public class Product {

    @Id
    private String productId;

    private String sproName;



    public String getSproName() {
        return sproName;
    }

    public void setSproName(String sproName) {
        this.sproName = sproName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
