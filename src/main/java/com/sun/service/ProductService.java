package com.sun.service;

import java.util.List;

public interface ProductService {
	
	/**
	 * Search.
	 *
	 * @param impeachSearchVO the impeach search VO
	 * @return the list
	 */
	List<String> search(final int id);
	
}
