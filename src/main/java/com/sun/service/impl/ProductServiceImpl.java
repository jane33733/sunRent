package com.sun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.ProductDao;
import com.sun.entity.Product;
import com.sun.service.ProductService;

/**
 * The Class ImpeachServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	/** The Constant LOGGER. */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Autowired
    private ProductDao productDao;

	@Override
	public List<Product> search(final int id) {
		List<Product> searchList = new ArrayList<>();
		try {
					
			searchList = productDao.getAll();
			
		} catch (Exception e) {
			LOGGER.debug("search fail : {}",e);
		}
		
		return searchList;
	}
	
	
}
