package com.sun.service;

import java.util.List;

import com.sun.common.vo.BatchType;
import com.sun.entity.SunBatch;

public interface BatchService {
	
	List<SunBatch> initialTime(BatchType batchType) throws Exception;
	
	int updateRunTime(final SunBatch updateVO);
	
}
