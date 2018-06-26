package com.aichat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = { "com.aichat" })
@MapperScan(value = "com.aichat.dao.genrated.dao")
@EnableAutoConfiguration
@ConfigurationProperties
public class App
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
