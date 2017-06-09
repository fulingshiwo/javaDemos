/* =============================================================
 * Created: [2016年2月16日] by ZhengChen
 * =============================================================
 *
 * Copyright 2014-2015 NetDragon Websoft Inc. All Rights Reserved
 *
 * =============================================================
 */

package com.cq.common.dao.impl;
import com.cq.common.dao.BaseDao;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengChen
 * @since 0.1.0
 */
@Repository(value = "baseDao")
public class BaseDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements BaseDao<T, PK> {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }

    public int save(String statement, Object parameter) {
        int affectedRowsNumber = 0;

        affectedRowsNumber = getSqlSession().insert(statement, parameter);

        return affectedRowsNumber;
    }

    public int save(String statement) {
        int affectedRowsNumber = 0;
        affectedRowsNumber = getSqlSession().insert(statement);

        return affectedRowsNumber;
    }

    public int delete(String statement, Object parameter) {
        int affectedRowsNumber = 0;

        affectedRowsNumber = getSqlSession().delete(statement, parameter);

        return affectedRowsNumber;
    }

    public int delete(String statement) {
        int affectedRowsNumber = 0;

        affectedRowsNumber = getSqlSession().delete(statement);

        return affectedRowsNumber;
    }

    public int update(String statement, Object parameter) {
        int affectedRowsNumber = 0;
        affectedRowsNumber = getSqlSession().update(statement, parameter);

        return affectedRowsNumber;
    }

    public int update(String statement) {
        int affectedRowsNumber = 0;

        affectedRowsNumber = getSqlSession().update(statement);

        return affectedRowsNumber;
    }

    public List<T> getList(String statement, Object parameter, Integer pageSize, Integer pageIndex) {
        List<T> list = new ArrayList<T>();

        RowBounds rowBounds = new RowBounds((pageIndex - 1) * pageSize, pageSize);

        list = getSqlSession().selectList(statement, parameter, rowBounds);

        return list;
    }

    public List<T> getList(String statement) {
        List<T> list = new ArrayList<T>();

        list = getSqlSession().selectList(statement);

        return list;
    }

    public List<T> getList(String statement, Object parameter) {
        List<T> list = new ArrayList<T>();

        list = getSqlSession().selectList(statement, parameter);

        return list;
    }

    public T get(String statement, Object parameter) {
        T object = null;

        object = getSqlSession().selectOne(statement, parameter);

        return object;
    }

    public T get(String statement) {
        T object = null;

        object = getSqlSession().selectOne(statement);

        return object;
    }

    public long getCount(String statement, Object parameter) {

        long cnt = getSqlSession().selectOne(statement, parameter);

        return cnt;
    }

    public long getCount(String statement) {

        long cnt = getSqlSession().selectOne(statement);

        return cnt;
    }

    // /-----------------返回整体

    /**
     * 返回泛型 Tuxs
     *
     * @param statement
     * @return
     */
    public <O> O QuerySingle(String statement, Object parameter) {
        O object = null;
        object = getSqlSession().selectOne(statement, parameter);
        return object;
    }

    /**
     * 返回泛型 Tuxs
     *
     * @param statement
     * @return
     */
    public <O> List<O> QueryMany(String statement, Object parameter) {
        List<O> list = new ArrayList<O>();
        list = getSqlSession().selectList(statement, parameter);
        return list;
    }

    /**
     * 返回泛型集合 Tuxs
     *
     * @param statement
     * @return
     */
    public <O> List<O> QueryMany(String statement, Object parameter, Integer pageSize, Integer pageIndex) {
        List<O> list = new ArrayList<O>();

        RowBounds rowBounds = new RowBounds((pageIndex - 1) * pageSize, pageSize);

        list = getSqlSession().selectList(statement, parameter, rowBounds);

        return list;
    }

    /*
     * (non-Javadoc)
     * @see com.nd.cloudofficeweb.common.dao.BaseDao#QueryMany(java.lang.String)
     */
    @Override
    public <O> List<O> QueryMany(String statement) {
        // TODO Auto-generated method stub
        List<O> list = new ArrayList<O>();
        list = getSqlSession().selectList(statement);
        return list;
    }

}
