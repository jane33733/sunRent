package com.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

@Lazy(false)
@Component
@EnableScheduling
public class MainSchedule implements SchedulingConfigurer {

	/** The LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainSchedule.class);
    
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask( new LineRun() , new LineTrigger() );
	}
	
	public static boolean changeTime(String changeTime) {
		LineTrigger.changeTime(changeTime);
		LOGGER.info("change time... " + changeTime);
		
		return true;
	}

    
}
