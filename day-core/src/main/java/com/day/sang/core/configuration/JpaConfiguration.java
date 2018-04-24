package com.day.sang.core.configuration;

import com.day.sang.core.common.BaseRepositoryFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactoryAresDataSource",
        transactionManagerRef="aresJpaTransactionManager", basePackages= { "com.day.sang.core.dao"},
        repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class JpaConfiguration {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier(value = "aresDataSource")
    private DataSource dataSource;

    @Autowired
    private  HibernateSettings hibernateSettings;

    private final static Logger logger = LoggerFactory.getLogger(JpaConfiguration.class);

    private Map<String, Object> getVendorProperties(HibernateSettings hibernateSettings) {
        return jpaProperties.getHibernateProperties(hibernateSettings);
    }

    @Bean(name = "entityManagerFactoryAresDataSource")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDataSource (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(getVendorProperties(hibernateSettings))
                .packages("com.day.sang.core.po")
                .persistenceUnit("dataSourcePersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerDataSource")
    @Primary
    public EntityManager entityManagerDataSource(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryDataSource(builder).getObject().createEntityManager();
    }

    @Bean(name = "aresJpaTransactionManager")
    @Primary
    PlatformTransactionManager JpaTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryDataSource(builder).getObject());
    }

}
