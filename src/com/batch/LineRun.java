package com.batch;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.service.LineService;

public class LineRun implements Runnable {

	/** The LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainSchedule.class);
    
    @Autowired
    private LineService lineService;
    
	@Override
	public void run() {
//		LineService lineService = new LineServiceImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		lineService.sendAnnouncement("現在時間 " + sdf.format(new Date()));
//		LOGGER.info("這裡是run dynamicCronTask is running...");
		LOGGER.info("[第一個]現在時間 " + sdf.format(new Date()));

	}

}
