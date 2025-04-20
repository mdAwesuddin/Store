package com.awes.store.configuration;

import com.awes.store.DB;
import com.awes.store.DevDB;
import com.awes.store.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "developement")
    public DB getDevDBBean() {
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDBBean() {
        return new ProdDB();
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
