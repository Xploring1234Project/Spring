package com.training.springrestapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringrestapiApplication {
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
	public static void main(String[] args) {

        SpringApplication.run(SpringrestapiApplication.class, args);
	}

}
