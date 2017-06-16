package com.sun.batch;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.support.CronTrigger;

import com.sun.service.LineService;

public class LineTrigger implements Trigger {

	@Autowired
    private LineService lineService;
	
	private static CronTrigger trigger = new CronTrigger("0/10 * * * * ?");
	
	
	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {
//		System.out.println("結果會執行");
        Date nextExec = trigger.nextExecutionTime(triggerContext);
//        Date nextExec = ((Trigger) trigger).nextExecutionTime(triggerContext);
        return nextExec;
	}
	
	public static boolean changeTime(String cron) {
		trigger = null;
		trigger = new CronTrigger(cron);
        return true;
	}
	
	

}
