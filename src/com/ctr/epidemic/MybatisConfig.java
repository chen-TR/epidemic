package com.ctr.epidemic;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/20 16:55
 * mybatis配置
 */
@Configuration
@MapperScan(basePackages="com.ctr.epidemic.mapper")
public class MybatisConfig {

    private static Logger logger = Logger.getLogger(MybatisConfig.class);

    //配置数据源
    @Bean(name="dataSource",destroyMethod = "close")
    public BasicDataSource basicDataSource(){

        //配置数据库连接参数
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1/epidemic");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");

        //设置连接池连接参数
        basicDataSource.setInitialSize(4);//初始化连接数
        basicDataSource.setMaxActive(50);//最大连接数
        basicDataSource.setMaxIdle(2);//最大空闲连接数
        basicDataSource.setMaxWait(4000);//最长等待时间
        basicDataSource.setDefaultAutoCommit(false);//设置默认不自动提交事务

        return basicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);

        //配置mapper.xml解析路径
        SqlSessionFactory sqlSessionFactory = null;
        try {
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/ctr/epidemic/mapper/*Mapper.xml");
            sqlSessionFactoryBean.setMapperLocations(resources);
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        }catch (Exception e){
            logger.error("解析映射xml文件时异常"+e.getMessage());
        }
        //配置映射对象所在的包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ctr.epidemic.model");
        //配置mybatis开启驼峰命名
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);

        return sqlSessionFactory;
    }
}
