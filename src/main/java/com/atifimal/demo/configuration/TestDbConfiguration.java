package com.atifimal.demo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "testDbEntityManagerFactory",
        basePackages = {"com.atifimal.demo.employee"})
public class TestDbConfiguration {

    @Primary
    @Bean(name = "testDbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.testdb")
    public DataSource testDbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "testDbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean testDbEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("testDbDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.atifimal.demo.employee")
                .persistenceUnit("employee")
                .build();
    }
}