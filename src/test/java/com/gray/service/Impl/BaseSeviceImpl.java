package com.gray.service.Impl;

import com.gray.dao.BaseDao;
import com.gray.service.BaseSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gray on 2017/4/8.
 */
@Service
public class BaseSeviceImpl implements BaseSevice {
    @Autowired
    private BaseDao dao;

    @Override
//    @Transactional(rollbackFor=Exception.class)
    public void insert(String sql, boolean flag) throws Exception {
        dao.insertSql(sql);
        // 如果flag 为 true ，抛出异常
        if (flag){
            throw new Exception("has exception!!!");
        }
    }

    @Override
    public void update(String sql) {
        dao.updateSql(sql);
    }

    @Override
    public void delete(String sql) {
        dao.deleteSql(sql);
    }

    @Override
    public Integer sum(){
        return dao.sum();
    }

}
