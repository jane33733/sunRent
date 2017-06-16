package com.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.sun.common.vo.BatchType;
import com.sun.entity.SunBatch;
import com.sun.service.BatchService;
import com.sun.service.impl.BatchServiceImpl;

@Lazy(false)
@Component
@EnableScheduling
public class EmailBatch implements SchedulingConfigurer {

	/** The LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailBatch.class);
    
    private static String cron = "0 0 0 25 12 ?";
	
    private EmailBatch() {
//    	BatchService batchService = new BatchServiceImpl();
//    	try {
//    		List<SunBatch> resultList = batchService.initialTime(BatchType.SEND_EMAIL);
//    		for (SunBatch sunBatch : resultList) {
//    			EmailBatch.changeTime(sunBatch.getCronStr());
//    		}
//		} catch (Exception e) {
//			LOGGER.error("Email Batch :{}",e);
//		}
    }
    
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				LOGGER.info("[第二個]時間 " + sdf.format(new Date()));
			}
		}, new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				// Change batch run cycle
				CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
			}
		});
	}
	
	public static boolean changeTime(String changeTime) {
		cron = changeTime;
		LOGGER.info("change time... " + changeTime);
		
		return true;
	}

    
}
