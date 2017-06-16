
package com.sun.controller;

import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.batch.LineTrigger;
import com.batch.SecondSchedule;
import com.sun.service.BatchService;



@Controller
@RequestMapping(value = "batch")
public class BatchController  {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchController.class);
    
    @Autowired
    private BatchService batchService;
    
    @ResponseBody
    @RequestMapping(value = "sendAnnouncement", method = RequestMethod.GET)
    public boolean sendAnnouncement(@RequestParam(required = true) String lineTime) throws Exception {
        LOGGER.info("[sendAnnouncement]------ change to {} ", lineTime);
        
        LOGGER.info("[sendAnnouncement]------ decode {} ", lineTime);
//        boolean result = lineService.sendAnnouncement("測試訊息");
//        MainSchedule ms = new MainSchedule();
        
        
//        boolean result = ms.SpringDynamicCronTask();
        
        return true;
    }
    
    

}
