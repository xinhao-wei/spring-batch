//package com.example.batch.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class HelloJob {
//    //job调度器
//    @Autowired
//    private JobLauncher jobLauncher;
//    //job构造器工厂
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//    //step构造器工厂
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//    //任务-step执行逻辑由tasklet完成
//    @Bean
//    public Tasklet tasklet_hello_1(){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println("Hello SpringBatch....");
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }
//    @Bean
//    public Tasklet tasklet_hello_2(){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println("Hello SpringBatch tasklet2 ....");
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }
//    //作业步骤-不带读/写/处理
//    @Bean
//    public Step step_hello_1(){
//        return stepBuilderFactory.get("step_hello_1")
//                .tasklet(tasklet_hello_1())
//                .build();
//    }
//    //作业步骤-不带读/写/处理
//    @Bean
//    public Step step_hello_2(){
//        return stepBuilderFactory.get("step_hello_2")
//                .tasklet(tasklet_hello_2())
//                .build();
//    }
//
//    /**
//     * SimpleStep校验执行顺序：InstanceId,stepName是否存在
//     */
//
//    //定义作业
//    @Bean
//    public Job job_hello_1(){
//        return jobBuilderFactory.get("hello-job_1")
//                // 定义两个步骤只有最后一个生效
//                //.start(step_hello1())
//                .start(step_hello_2()) // steps.set(0, step); 将第一个启动的step覆盖
//                .build();
//    }
//
//    /**
//     * 定义两个名字和步骤完全相同的job时只有一个会执行
//     * 第二个报：Step already complete or not restartable, so no action to execute: StepExecution
//     * @return
//     */
//    @Bean
//    public Job job_hello_2(){
//        return jobBuilderFactory.get("hello-job_2")
//                // 定义两个步骤只有最后一个生效
//                //.start(job_hello_1())
//                .start(step_hello_2()) // steps.set(0, step); 将第一个启动的step覆盖
//                .build();
//    }
//}
