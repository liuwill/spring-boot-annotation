package com.liuwill.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2015/10/27.
 */
@Configuration
@EnableTransactionManagement
@ConditionalOnClass({ JdbcTemplate.class, PlatformTransactionManager.class })
public class TransactionConfig {

    @Autowired
    //@Qualifier("dataSource")
    //private DataSource dataSource;
    private DataSource memoDataSource;

    public DataSource getDefaultDataSource(){
        return memoDataSource;
    }

    @Bean
    @ConditionalOnMissingBean(name = "transactionManager")
    @ConditionalOnBean(DataSource.class)
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDefaultDataSource());
    }

    @ConditionalOnMissingBean(AbstractTransactionManagementConfiguration.class)
    @Configuration
    @EnableTransactionManagement
    protected static class TransactionManagementConfiguration {

    }
}
