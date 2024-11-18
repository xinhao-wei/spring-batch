package com.example.batch.config.paramert;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author xinhao
 * @Date 2024/11/13 16:55
 *
 * 作业参数获取
 * 作业参数为国定只第二次执行就会报异常：A job instance already exists and is complete for parameters={name=job_param}.  If you want to run this job again, change the parameters.
 * Spring Batch 相同Job名与相同标识参数只能成功执行一次。
 */
@Configuration
public class JobParamObtain {
    //job构造器工厂
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    //step构造器工厂
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Tasklet tasklet_param_obtain() {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                Map<String, Object> parameters = chunkContext.getStepContext().getJobParameters();
                System.out.println("params--getStepContext--name:" + parameters.get("name"));
                return RepeatStatus.FINISHED;
            }
        };
    }

    // 必须贴上@StepScope ，表示在启动项目的时候，不加载该Step步骤bean，等step1()被调用时才加载。这就是所谓延时获取。
    @StepScope
    @Bean
    public Tasklet tasklet_param_obtain2(@Value("#{jobParameters['name']}")String name){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("params--@value--name:" + name);
                return RepeatStatus.FINISHED;
            }
        };
    }

    @Bean
    public Step step_param_obtain_1(){
        return stepBuilderFactory.get("step_param_obtain_1")
                .tasklet(tasklet_param_obtain())
                .build();
    }
    @Bean
    public Step step_param_obtain_2(){
        return stepBuilderFactory.get("step_param_obtain_2")
                .tasklet(tasklet_param_obtain2(null))
                .build();
    }

    @Bean
    public Job job_param_obtain_1(){
        return jobBuilderFactory.get("job_param_obtain_1")
                .start(step_param_obtain_1())
                .build();
    }

    @Bean
    public Job job_param_obtain_2(){
        return jobBuilderFactory.get("job_param_obtain_2")
                .start(step_param_obtain_2())
                .build();
    }

}
