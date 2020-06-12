package it.pcc.jberetwildfly.rest.batch;

import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Stateless;

@Stateless
public class Scheduler {
	
	public String launchBatchlet() {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties props = new Properties();
		props.setProperty("customString", "customString");
		props.put("customInt", 5);
		jobOperator.start("testJob", props);
		return "batch launched";
	}

}
