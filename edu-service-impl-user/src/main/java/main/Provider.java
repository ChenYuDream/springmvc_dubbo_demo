package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author yu_chen
 * @create 2017-11-13 18:22
 **/
public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring-context.xml");
        context.start();

        System.in.read();
    }

}
