package com.liuwill.demo;

/**
 * Created by Administrator on 2015/10/26.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;

/**
 * Created by Administrator on 2015/10/21.
 */
@SpringBootApplication
/*@Configuration
@ComponentScan(basePackages = {
        "cn.arkfund.cht.controller","cn.arkfund.cht.services","cn.arkfund.cht.dao"
})*/
public class DemoBootApplication {

    /*
    @Autowired
    private PlatformTransactionManager transactionManager;
    */

    public static void main(String[] args) {
        //SpringApplication app = new SpringApplication(MySpringConfiguration.class);
        ApplicationContext ctx = SpringApplication.run(DemoBootApplication.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

}