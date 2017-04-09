package com.gray.dao;

public interface BaseDao{
    /**
     * 简单的插入数据库的sql语句
     * @param sql
     */
    void insertSql(String sql);
    /**
     * 简单的更新sql语句
     * @param sql
     */
    void updateSql(String sql);

    /**
     * 简单的删除sql语句
     * @param sql
     */
    void deleteSql(String sql);

    /**
     * 获得金额总值，用于事务测试
     * @return
     */
    Integer sum();
}