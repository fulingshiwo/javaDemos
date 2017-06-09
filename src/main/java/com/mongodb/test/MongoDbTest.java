package com.mongodb.test;

import com.mongodb.dao.ProductDao;
import com.mongodb.dao.ProductDaoImpl;
import com.mongodb.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by ChenQuan on 2017/5/27.
 */
public class MongoDbTest {
    /**
     * 测试
     *
     * @param args
     */

    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext(
                "classpath:spring.xml");
        Class r = Product.class;

        ProductDao productDao = (ProductDaoImpl) ac.getBean("productDaoImpl");

	   //添加产品
        Product addProduct=new Product();
        addProduct.setSproName("新增产品名称");
        productDao.saveProduct(addProduct);
    }
}
