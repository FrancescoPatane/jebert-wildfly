package it.pcc.jberetwildfly.rest.batch.task;

import javax.batch.api.AbstractBatchlet;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;

public class TestJob  extends AbstractBatchlet {
	
	@Inject
	StepContext stepContext;
	
	@Inject
	JobContext jobContext;

	@Override
	public String process() throws Exception {
		System.out.println("##############");
		System.out.println(stepContext.getProperties().get("message"));
		System.out.println("##############");
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		JobExecution  exec = jobOperator.getJobExecution(jobContext.getExecutionId());
		System.out.println(exec.getJobParameters().get("customString"));
		System.out.println("##############");
		System.out.println(exec.getJobParameters().get("customInt"));
		System.out.println("##############");
		return BatchStatus.COMPLETED.toString();
	}

}
