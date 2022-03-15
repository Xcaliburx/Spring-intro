package com.gdn.springintro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public MarvelMovie marvelMovie(){
        return new MarvelMovie();
    }
}
