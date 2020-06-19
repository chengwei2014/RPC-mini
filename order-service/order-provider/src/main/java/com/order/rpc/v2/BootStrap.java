package com.order.rpc.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * RPC服务端发布
 * 2020-06-18
 */
@Configuration
@ComponentScan("com.order.rpc.v2")
public class BootStrap {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BootStrap.class);
    }
}
