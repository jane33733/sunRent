package com.sun.batch;

import java.text.SimpleDateFormat;
import java.util.Date;

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

@Lazy(false)
@Component
@EnableScheduling
public class SecondSchedule implements SchedulingConfigurer {

	/** The LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SecondSchedule.class);
    
    
    private static String cron;
	
	public SecondSchedule() {
		cron = "0/5 * * * * ?";
		
		// 开启新线程模拟外部更改了任务执行周期
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(15 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				cron = "0/10 * * * * ?";
				System.err.println("[第二個]: " + cron);
			}
		}).start();
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
				// 任务触发，可修改任务的执行周期
				CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
			}
		});
	}
	
	public static boolean changeTime(String changeTime) {
		LineTrigger.changeTime(changeTime);
		LOGGER.info("change time... " + changeTime);
		
		return true;
	}

    
}
