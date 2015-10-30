package com.liuwill.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2015/10/26.
 */
@Configuration
@EnableTransactionManagement
@ConditionalOnClass({ JdbcTemplate.class, PlatformTransactionManager.class })
public class DatabaseConfig {//implements Ordered {

    /*
    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
    */

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplate")
    @Autowired
    @Qualifier("dataSource")
    public JdbcTemplate masterJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /*@Bean(name = "memoDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.h2")
    public DataSource momeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "memoJdbcTemplate")
    @Autowired
    @Qualifier("memoDataSource")
    public JdbcTemplate momeJdbcTemplate(DataSource memoDataSource) {
        return new JdbcTemplate(memoDataSource);
    }*/

}
