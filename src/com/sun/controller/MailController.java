package com.sun.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.service.MailService;

@Controller
@RequestMapping(value = "mail")
public class MailController {

	private Logger LOGGER = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private MailService mailService;
	
	@ResponseBody
	@RequestMapping(value="sendEmail", method = RequestMethod.GET)
	public boolean sendEmail(){
		LOGGER.debug("[sendMail] debug");
		LOGGER.info("[sendMail] info");
		boolean outcome = false;
		
		outcome = mailService.sendMailByList();
		
		return outcome;
	}
	
}
