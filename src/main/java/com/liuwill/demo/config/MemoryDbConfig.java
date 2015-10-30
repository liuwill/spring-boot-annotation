package com.liuwill.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2015/10/27.
 */
@Configuration
//@EnableTransactionManagement
//@ConditionalOnClass({ JdbcTemplate.class, PlatformTransactionManager.class })
public class MemoryDbConfig {
    @Bean(name = "memoDataSource")
    @ConfigurationProperties(prefix="spring.h2")
    public DataSource momeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "memoJdbcTemplate")
    @Autowired
    @Qualifier("memoDataSource")
    public JdbcTemplate momeJdbcTemplate(DataSource memoDataSource) {
        return new JdbcTemplate(memoDataSource);
    }
}
