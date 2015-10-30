package com.liuwill.testng.data;

import com.liuwill.demo.DemoBootApplication;
import com.liuwill.demo.dao.DemoUsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2015/10/26.
 */
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
//@SpringApplicationConfiguration(classes = DemoBootApplication.class)
//@WebIntegrationTest("server.port:0")
@DirtiesContext
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = true)
//@TransactionConfiguration(defaultRollback = true,transactionManager = "transactionManager")
@Transactional
public class DataDaoTest extends AbstractTransactionalTestNGSpringContextTests {//AbstractTestNGSpringContextTests{
    @Autowired
    private DemoUsersDao demoUsersDao;

    @Test(groups = {"data"})
    public void getUserByMobile(){
        System.out.println("18608776684");
        System.out.println(demoUsersDao.getUserByMobile("18608776684"));
    }

    @Test(groups = {"data"})
    public void addDemoUser(){
        int passwordInt = (int)(Math.random()*100000);
        String password = String.valueOf(passwordInt);

        System.out.println(demoUsersDao.addDemoUser("liuwei",password));
    }

}
