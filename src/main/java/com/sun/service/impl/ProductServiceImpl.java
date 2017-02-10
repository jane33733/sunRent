package com.sun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.service.ProductService;

/**
 * The Class ImpeachServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	/** The Constant LOGGER. */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductServiceImpl.class);
    

	@Override
	public List<String> search(final int id) {
		List<String> searchList = new ArrayList<>();
		try {
					
			searchList.add("鹹派");
			searchList.add("黑森林");
			
		} catch (Exception e) {
			LOGGER.debug("search fail : {}",e);
		}
		
		return searchList;
	}
	
	
}
