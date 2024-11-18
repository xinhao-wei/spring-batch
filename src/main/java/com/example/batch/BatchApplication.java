package com.example.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {
    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }
    //@Bean
    //public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    //    return args -> {
    //        String[] beanNames = ctx.getBeanDefinitionNames();
    //        Arrays.stream(beanNames).forEach(System.out::println);
    //        // 你也可以在这里获取特定的Bean并进行操作
    //    };
    //}
}
