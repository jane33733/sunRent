package com.sun.service;

import java.util.List;

import com.sun.entity.SunBatch;

public interface BatchService {
	
	List<SunBatch> initialTime() throws Exception;
	
	int updateRunTime(final SunBatch updateVO);
	
}
