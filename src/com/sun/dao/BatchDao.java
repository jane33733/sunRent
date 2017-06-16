package com.sun.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sun.config.DataBaseConfig;
import com.sun.entity.SunBatch;

@Transactional
@Repository
public class BatchDao extends BaseDao{

	
	/**
	 * 以id編號取出批次設定資料
	 * @param id
	 * @return
	 */
	@Transactional
	public List<SunBatch> queryById(String id) throws Exception{
		List<SunBatch> batchList =  new ArrayList<>();
		final StringBuilder str = new StringBuilder();
		
		str.append(" SELECT * FROM sun_batch ");
		if (StringUtils.isNoneEmpty(id)) {
			str.append(" WHERE id = :id ");
		}
		
		DataBaseConfig dbc = new DataBaseConfig();
		
		SessionFactory sf = dbc.getSessionFactory(dbc.getDataSource()); 
		SQLQuery query = sf.openSession().createSQLQuery(str.toString());
		if (StringUtils.isNoneEmpty(id)) {
			query.setParameter("id", id);
		}
		query.addEntity(SunBatch.class);
		
		List resultList = query.list();
		
		for (int i = 0; i < resultList.size(); i++) {
			SunBatch batch = (SunBatch)resultList.get(i);
			batchList.add(batch);
		}
		
		return batchList;
		
	}
	
	
	
	public int update(SunBatch updateVO) throws Exception{
		final StringBuilder str = new StringBuilder();
		
		str.append(" UPDATE sun_batch ");
		str.append(" SET cron_str = :cronStr ");
		str.append(" 	,run_time = :runTime ");
		str.append(" 	,update_time = :updateTime ");
		str.append(" WHERE id = :id ");

		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(str.toString());
		query.setParameter("cronStr", updateVO.getCronStr());
		query.setParameter("runTime", updateVO.getRunTime());
		query.setParameter("updateTime", updateVO.getUpdateTime());
		query.setParameter("id", updateVO.getId());
		query.addEntity(SunBatch.class);
		
		int result = query.executeUpdate();
		
		return result;
		
	}
	
}
