package com.atifimal.demo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "testDb2EntityManagerFactory",
        basePackages = {"com.atifimal.demo.staff"})
public class TestDb2Configuration {

    @Bean(name = "testDb2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.testdb2")
    public DataSource testDb2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testDb2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean testDb2EntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("testDb2DataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.atifimal.demo.staff")
                .persistenceUnit("staff")
                .build();
    }
}