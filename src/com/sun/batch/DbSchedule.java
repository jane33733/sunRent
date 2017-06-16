package com.sun.batch;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sun.common.vo.BatchType;
import com.sun.entity.SunBatch;
import com.sun.service.BatchService;
import com.sun.service.impl.BatchServiceImpl;

@Service
@Configurable
public class DbSchedule {
	
	/** The Constant LOGGER. */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DbSchedule.class);
    
//	@Autowired
//    private BatchService batchService;
	
	
	@PostConstruct
	@Scheduled(cron = "0 48 9 * * *")
    public void work() {
		LOGGER.info("[資料庫設定時間] had initial time ");
		
		try {
			BatchService batchService = new BatchServiceImpl();
			List<SunBatch> resultList = batchService.initialTime();
			for (SunBatch sunBatch : resultList) {
				BatchType batchType = BatchType.lookup(sunBatch.getId());
				
				switch (batchType) {
				case SEND_LINE:
					LineTrigger.changeTime(sunBatch.getCronStr());
					break;
				case SEND_EMAIL:
					SecondSchedule.changeTime(sunBatch.getCronStr());
					break;
					
				default:
					break;
				}
				
			}
			LOGGER.info("[資料庫設定時間] 結束 time ");
		} catch (Exception e) {
			LOGGER.debug("[資料庫設定時間] error :{}",e);
			e.printStackTrace();
		}
		
		
    }
	
}
