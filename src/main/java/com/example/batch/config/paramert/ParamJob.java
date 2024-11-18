//package com.example.batch.config.paramert;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.repository.support.SimpleJobRepository;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ParamJob {
//    //job构造器工厂
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//    //step构造器工厂
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Tasklet tasklet_param(){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println("param SpringBatch Param Other ....");
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }
//    @Bean
//    public Step step_param(){
//        return stepBuilderFactory.get("step_param")
//                .tasklet(tasklet_param())
//                .build();
//    }
//
//    /**
//     * JobInstance的ID为数据库查询
//     * {@link SimpleJobRepository} createJobExecution()方法
//     * 通过JobName和使用jobParameters参数生成的key查询Job是否存在
//     * 若不存在则创建
//     * 若存在则通过jobInstance查询JobExecution判断执行状态若不是UNKNOW则设置执行上下文executionContext更新执行返回jobExecution
//     *
//     * @return
//     */
//    @Bean
//    public Job job_param(){
//        return jobBuilderFactory.get("param-job")
//                .start(step_param())
//                .build();
//    }
//}
