package com.sun.service;

import java.util.List;

import com.sun.entity.Product;

public interface ProductService {
	
	/**
	 * Search.
	 *
	 * @param impeachSearchVO the impeach search VO
	 * @return the list
	 */
	List<Product> search(final int id);
	
}
