package com.sun.service;

public interface LineService {

	boolean sendAnnouncement(String message);
	
	String getBatTime(String messageType);
}
