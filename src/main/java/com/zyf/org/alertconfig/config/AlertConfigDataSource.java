package com.zyf.org.alertconfig.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author yanfengzhang
 * @description
 * @date 2021/1/21  17:53
 */
public class AlertConfigDataSource {
    private String localMapper = "classpath:mapper/*.xml";

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource mAlertdataSource(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public SqlSessionFactory buildSqlSessionFactory(@Qualifier("alertConfigDataSource") DataSource dataSource) throws  Exception {
        SqlSessionFactoryBean bean;
        bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(localMapper));
        return bean.getObject();
    }
}
