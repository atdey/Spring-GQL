package com.hashedin.javacapability.graphql.config;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setPropertyCondition(context -> {
//            //if the object is a PersistentCollection could be not initialized
//            //in case of lazy strategy, in this case the object will not be mapped:
//            return (!(context.getSource() instanceof PersistentCollection));
//        });
        return modelMapper;
    }
}
