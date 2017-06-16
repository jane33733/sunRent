
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

import com.batch.EmailBatch;
import com.batch.LineBatch;
import com.sun.service.LineService;



/**
 * The Class ImpeachController.
 */
@Controller
@RequestMapping(value = "line")
public class LineController  {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LineController.class);
    
    @Autowired
    private LineService lineService;
    
    
    @ResponseBody
    @RequestMapping(value = "sendAnnouncement", method = RequestMethod.GET)
    public boolean sendAnnouncement(@RequestParam(required = true) String lineTime) throws Exception {
        LOGGER.info("[sendAnnouncement]------ change to {} ", lineTime);
        
        lineTime = URLDecoder.decode(lineTime, "UTF-8");
        LOGGER.info("[sendAnnouncement]------ decode {} ", lineTime);
//        boolean result = lineService.sendAnnouncement("測試訊息");
//        MainSchedule ms = new MainSchedule();
        
        
        boolean result = LineBatch.changeTime(lineTime);
        EmailBatch.changeTime("0/10 * * * * ?");
        LOGGER.info("[sendAnnouncement]------ final result: {} ", result);
//        boolean result = ms.SpringDynamicCronTask();
        
        return true;
    }
    
    

}
