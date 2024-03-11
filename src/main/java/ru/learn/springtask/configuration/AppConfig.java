package ru.learn.springtask.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.learn.springtask.data.impl.CsvFormat;

@Configuration
public class AppConfig {
    @Bean
    Class datable(){
        return CsvFormat.class;
    }

}
