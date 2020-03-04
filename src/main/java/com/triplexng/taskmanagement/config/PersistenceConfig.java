package com.triplexng.taskmanagement.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

    private static final Logger LOG = LoggerFactory.getLogger(PersistenceConfig.class);

    @Bean
    public BeanA beanA(){
        LOG.debug("Project Configuration >> Configuring BeanA");
        return new BeanA();
    }

}
