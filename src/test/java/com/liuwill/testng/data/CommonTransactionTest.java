package com.liuwill.testng.data;

import com.liuwill.demo.DemoBootApplication;
import com.liuwill.demo.dao.CommonUserDao;
import com.liuwill.demo.service.DemoCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/27.
 */
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
@DirtiesContext
@WebAppConfiguration
@Transactional
//@TransactionConfiguration(defaultRollback = true)
public class CommonTransactionTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private DemoCommonService demoCommonService;

    @Test(groups = {"data"})
    public void addDemoUser(){
        int passwordInt = (int)(Math.random()*100000);
        String password = String.valueOf(passwordInt);

        String username = "liuwill";
        String mobile = "18608776684";
        String email = "liuwill@live.com";

        Map commonUserMap = new HashMap();
        commonUserMap.put("username",username);
        commonUserMap.put("mobile",mobile);
        commonUserMap.put("email",email);
        commonUserMap.put("password",password);

        System.out.println(demoCommonService.addCommonUser(commonUserMap));
    }
}
