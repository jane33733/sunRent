package com.sun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sun.service.MailService;
import com.sun.util.MailUtils;

@Service
public class MailServiceImpl implements MailService{

	/** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Override
	public boolean sendMailByList() {
		
		boolean isThreadStart = false; 
		
//		Properties properties = new Properties();
//		String configFile = "mail.properties";
		try {
//			String filePath = this.getClass().getClassLoader().getResourceAsStream(configFile);
//			properties.load( this.getClass().getClassLoader().getResourceAsStream(configFile) );
			
			List<String> receiverList = new ArrayList<String>();
			receiverList.add("kitty33733@yahoo.com");
			String subject = "嘗試寄信";
			String content = "這裡是內容";
			MailUtils.sendMail(receiverList, subject, content);
			
//			MailSender mailSender = new MailSender("kitty33733@yahoo.com", "測試寄信", "這是信件內容", properties);
//			mailSender.run();
			
			isThreadStart = true;
			
		} catch (Exception e) {
			LOGGER.info("send mail error : ",e);
		}
		
		LOGGER.info("[sendMail] thread is start : {}", isThreadStart);
		
		return isThreadStart;
	}
	
}
