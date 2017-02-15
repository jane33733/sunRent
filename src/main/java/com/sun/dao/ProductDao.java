package com.sun.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sun.entity.Product;

@Transactional
@Repository
public class ProductDao extends BaseDao{

	public List<Product> getAll() {
        final StringBuilder str = new StringBuilder();
        str.append(" SELECT * FROM sun_product ");

        final Query query = this.sessionFactory.getCurrentSession().createSQLQuery(str.toString());
//        final Query query = this.sessionFactory.getCurrentSession().createQuery(str.toString());
//        query.setString("email", email);
//        query.setInteger("status", status.getValue());

        @SuppressWarnings("unchecked")
		final List<Product> productList = query.list();
        return productList;

    }
}
