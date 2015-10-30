package com.liuwill.demo.service;

import com.liuwill.demo.dao.CommonUserDao;
import com.liuwill.demo.model.CommonUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Administrator on 2015/10/27.
 */
@Service
@Transactional
public class DemoCommonService {
    @Autowired
    private CommonUserDao commonUserDao;

    public boolean addCommonUser(Map commonUserMap){
        String username = (String)commonUserMap.get("username");
        String mobile = (String)commonUserMap.get("mobile");
        String email = (String)commonUserMap.get("email");
        String password = (String)commonUserMap.get("password");

        CommonUserModel commonUserModel = new CommonUserModel();
        commonUserModel.setDisplayName(username);
        commonUserModel.setUsername(username);
        commonUserModel.setUserLogin(username);
        commonUserModel.setMobile(mobile);
        commonUserModel.setPassword(password);
        commonUserModel.setEmail(email);

        int addResult = commonUserDao.addSimpleUser(commonUserModel);
        if(addResult != 1){
            throw new RuntimeException();
        }
        return true;
    }
}
