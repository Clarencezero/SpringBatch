package com.springbatch.springbatch.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.util.Date;

/**
 * 监听器
 * 1. 无论JOB执行成功或是失败,都会调用afterJob,都可以从JobExecution中获取运行结果后,根据结果来进行不同的处理
 */
public class PeopleListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        Date createTime = jobExecution.getCreateTime();
        BatchStatus batchStatus = jobExecution.getStatus();
        Long jobId = jobExecution.getJobId();
        Date startTime = jobExecution.getStartTime();


        System.out.println("创建时间: " + createTime);
        System.out.println("开始时间: " + startTime);
        System.out.println("批次状态: " + batchStatus.isRunning());
        System.out.println("任务ID: " + jobId);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("==================== 任务完成");
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            System.out.println("==================== 任务失败");
        }
        System.out.println("任务结束时间: " + jobExecution.getEndTime());
    }
}
