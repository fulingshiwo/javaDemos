package com.mongodb.common;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * description:
 *
 * @author <a href='mailto:dennisit@163.com'> Cn.苏若年 (En.dennisit)</a> Copy Right since 2013-10-13
 *
 * com.pudp.base.MongoGenDao.java
 *
 */

public abstract class MongoGenDao<T> {

    //@Autowired
    protected MongoTemplate mongoTemplate;


    /**
     * 保存一个对象
     *
     *
     * @param t
     * @return
     */
    public void save(T t){
        this.mongoTemplate.save(t);
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}