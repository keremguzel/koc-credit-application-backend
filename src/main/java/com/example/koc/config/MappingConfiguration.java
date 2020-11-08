package com.example.koc.config;

import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfiguration {

    @Bean
    public Mapper mapper() throws Exception {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        return mapper;
    }
}