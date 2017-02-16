package com.sun.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sun.entity.Product;

@Transactional
@Repository
public class ProductDao extends BaseDao{

	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		List<Product> productList =  new ArrayList<>();
        final StringBuilder str = new StringBuilder();
        str.append(" FROM Product ");

        final Query query = this.sessionFactory.getCurrentSession().createQuery(str.toString());
//        final Query query = this.sessionFactory.getCurrentSession().createQuery(str.toString());
//        query.setString("email", email);
//        query.setInteger("status", status.getValue());

        productList = (List<Product>)query.list();
        
        
        return productList;

    }
	
	public List<Product> getByTime() {
		List<Product> productList =  new ArrayList<>();
		final StringBuilder str = new StringBuilder();
		str.append(" SELECT * FROM sun_product ");
		
		final Query query = this.sessionFactory.getCurrentSession().createSQLQuery(str.toString());
//        final Query query = this.sessionFactory.getCurrentSession().createQuery(str.toString());
//        query.setString("email", email);
//        query.setInteger("status", status.getValue());
		
		List resultList = query.list();
		
		for (int i = 0; i < resultList.size(); i++) {
			Product product = (Product)resultList.get(i);
			productList.add(product);
		}
		
		return productList;
		
	}
}
