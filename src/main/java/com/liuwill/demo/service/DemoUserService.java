package com.liuwill.demo.service;

import com.liuwill.demo.dao.DemoUsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2015/10/30.
 */
@Service
public class DemoUserService {

    @Autowired
    private DemoUsersDao demoUsersDao;

    public Map getUserByMobile(String mobile){
        return demoUsersDao.getUserByMobile(mobile);
    }
}
