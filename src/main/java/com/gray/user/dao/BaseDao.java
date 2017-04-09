package com.gray.user.dao;

public interface BaseDao<T> {
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
}