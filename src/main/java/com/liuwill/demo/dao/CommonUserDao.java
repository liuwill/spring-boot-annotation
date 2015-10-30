package com.liuwill.demo.dao;

import com.liuwill.demo.model.CommonUserModel;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2015/10/27.
 */
@Component
public class CommonUserDao extends BaseDao{

    private final String ADD_COMMON_USER = "insert into COMMON_USER (MOBILE, \n" +
            "  USERNAME, DISPLAY_NAME, USER_LOGIN, \n" +
            "  PASSWORD, EMAIL)\n" +
            "values (?,?,?,?,?,?)";

    public int addSimpleUser(final CommonUserModel commonUserModel){
        int resultInt = getJdbcTemplate().update(ADD_COMMON_USER, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setObject(1,commonUserModel.getMobile());
                ps.setObject(2,commonUserModel.getUsername());
                ps.setObject(3,commonUserModel.getDisplayName());
                ps.setObject(4,commonUserModel.getUserLogin());
                ps.setObject(5,commonUserModel.getPassword());
                ps.setObject(6,commonUserModel.getEmail());
            }
        });

        return resultInt;
    }
}
