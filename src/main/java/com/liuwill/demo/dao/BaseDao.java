package com.liuwill.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015/10/26.
 */
@Component
public abstract class BaseDao {
    @Autowired
    //@Qualifier("jdbcTemplate")
    //private JdbcTemplate jdbcTemplate;
    private JdbcTemplate memoJdbcTemplate;
    //private final JdbcTemplate jdbcTemplate;

    /*@Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    public JdbcTemplate getJdbcTemplate(){
        return memoJdbcTemplate;
    }

}