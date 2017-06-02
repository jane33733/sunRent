package com.sun.service.impl;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sun.service.LineService;

@Service
public class LineServiceImpl implements LineService{

	/** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LineServiceImpl.class);
	
    private static final String strEndpoint = "https://notify-api.line.me/api/notify";
    
	@Override
	public boolean sendAnnouncement(String message) {
		
//		boolean isThreadStart = false; 
//		String message = "第三次測試";
		String lineToken = "eOKIrVkJeqRsaAWKSXvWwSbrfGb0a4qhCtfcxYspkFt";
		boolean result = false;
   		try {
			message = URLEncoder.encode(message, "UTF-8");
			String strUrl = strEndpoint;
			URL url = new URL( strUrl );
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.addRequestProperty("Authorization",  "Bearer " + lineToken);
			connection.setRequestMethod( "POST" );
			connection.addRequestProperty( "Content-Type", "application/x-www-form-urlencoded" );
			connection.setDoOutput( true );
			String parameterString = new String("message=" + message);
			PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
			printWriter.print(parameterString);
			printWriter.close();
			connection.connect();
            
			int statusCode = connection.getResponseCode();
		        if ( statusCode == 200 ) {
		        	result = true;
		        } else {
		        	throw new Exception( "Error:(StatusCode)" + statusCode + ", " + connection.getResponseMessage() );
		        }
		        connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LOGGER.info("[sendLine] result is : {}", result);
		
		return result;
	}

	@Override
	public String getBatTime(String messageType) {
		// TODO Auto-generated method stub
		return "0/30 * * * * ?";
	}
	
}
