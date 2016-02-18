package com.brgarcia

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.sql.DataSource
import java.util.Properties

@Configuration
@EnableTransactionManagement
open class HibernateConfig {

    @Bean
    open fun sessionFactory(): LocalSessionFactoryBean {
        val sessionFactory = LocalSessionFactoryBean()
        sessionFactory.setDataSource(dataSource())
        sessionFactory.setPackagesToScan(*arrayOf("com.brgarcia"))
        sessionFactory.hibernateProperties = hibernateProperties()
        return sessionFactory
    }

    @Bean
    @Autowired
    open fun transactionManager(sessionFactory: SessionFactory): HibernateTransactionManager {
        return HibernateTransactionManager(sessionFactory)
    }

    private fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("org.h2.Driver")
        dataSource.url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"
        return dataSource
    }

    private fun hibernateProperties(): Properties {
        val properties = Properties()
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
        properties.put("hibernate.show_sql", true)
        properties.put("hibernate.format_sql", true)
        properties.put("hibernate.hbm2ddl.auto", "create");
        return properties
    }

}
