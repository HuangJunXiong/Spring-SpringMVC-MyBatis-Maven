package com.gray.service.Impl;

import com.gray.dao.BaseDao;
import com.gray.service.BaseSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gray on 2017/4/8.
 */
@Service
public class BaseSeviceImpl implements BaseSevice {
    @Autowired
    private BaseDao dao;
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
