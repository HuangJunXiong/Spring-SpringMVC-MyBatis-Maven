package com.gray.user.service.impl;

import com.gray.user.dao.BaseDao;
import com.gray.user.service.BaseSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by gray on 2017/4/8.
 */
@Service
public class BaseSeviceImpl implements BaseSevice {
    @Autowired
    @Qualifier("baseDao")
    private BaseDao<?> dao;

    @Override
    public void insert(String sql) {
        dao.insertSql(sql);
    }

    @Override
    public void update(String sql) {
        dao.updateSql(sql);
    }

    @Override
    public void delete(String sql) {
        dao.deleteSql(sql);
    }
}
