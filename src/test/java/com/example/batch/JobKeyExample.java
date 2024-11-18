package com.example.batch;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
 
public class JobKeyExample {
    public static void main(String[] args) {
        // 假设我们有一个作业名称
        String jobName = "myJob";
        
        // 创建作业参数
        JobParameters jobParameters = new JobParametersBuilder()
            .addString("key1", "value1")
            .addLong("key2", 123L)
            .toJobParameters();
        
        // 使用作业名称和参数创建JobKey
        //JobKey jobKey = new JobKey(jobName, jobParameters);
        
        // 打印生成的JobKey
        //System.out.println("JobKey: " + jobKey);
    }
}