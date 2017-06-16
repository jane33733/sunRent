package com.sun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.common.vo.BatchType;
import com.sun.dao.BatchDao;
import com.sun.entity.SunBatch;
import com.sun.service.BatchService;


@Service
public class BatchServiceImpl implements BatchService {
	
	/** The Constant LOGGER. */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BatchServiceImpl.class);
    
    private BatchDao batchDao = new BatchDao();
    
	@Override
	public List<SunBatch> initialTime(BatchType batchType) throws Exception {
		LOGGER.info("[BatchService]");
		List<SunBatch> resultList = new ArrayList<>();
//		BatchDao batchDao = new BatchDao();
		if (batchType == null) {
			resultList = batchDao.queryById(null);
		} else {
			resultList = batchDao.queryById(batchType.getValue());
		}
		return resultList;
	}

	@Override
	public int updateRunTime(SunBatch updateVO) {
		int result = 0;
		try {
			result = batchDao.update(updateVO);
		} catch (Exception e) {
			LOGGER.debug("fail : {}",e);
		}
		
		return result;
	}
	
	
}