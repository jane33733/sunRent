
package com.sun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.service.ProductService;


/**
 * The Class ImpeachController.
 */
@Controller
@RequestMapping(value = "product")
public class ProductController  {

    /** The Constant LOGGER. */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductController.class);

    /** The impeach service. */
    @Autowired
    private ProductService productService;
    
    /**
     * Search.
     *
     * @param statisticsRptQueryVO the statistics rpt query VO
     * @return the exe result VO
     * @throws Exception the exception
     */
    @ResponseBody
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public List<String> search(@RequestBody int id) throws Exception {
        LOGGER.debug("[search]------ Start : contentType= {}", id);
        
        if (id != 0) {
        	return productService.search(id);
		} else {
			LOGGER.error("input parameter is invilad....{}", id);
			throw new IllegalArgumentException();
		}
        
    }
    

}
