package com.liuwill.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/26.
 */
@Component
public class DemoUsersDao extends BaseDao{

    public Map getUserByMobile(String mobile){
        try{
            return getJdbcTemplate().queryForMap("SELECT * FROM common_user WHERE mobile=?",new Object[]{mobile});
        }catch (EmptyResultDataAccessException exception){
            return null;
        }

    }

    @Transactional
    public int addDemoUser(final String username,final String password){
        Map demoUserMap = new HashMap();
        demoUserMap.put("username",username);
        demoUserMap.put("password",password);

        int resultInt = getJdbcTemplate().update("insert into demo_users (username, password, enabled) values (?, ?, true);", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setObject(1,username);
                ps.setObject(2,password);
            }
        });

        return resultInt;
    }
}
