
package com.sun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.entity.Product;
import com.sun.request.vo.ProductVO;
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
    public List<Product> search(@RequestBody ProductVO productVO) throws Exception {
        LOGGER.debug("[search]------ Start : contentType= {}", productVO.getProductId());
        
        if (productVO.getProductId() != 0) {
        	return productService.search(productVO.getProductId());
		} else {
			LOGGER.error("input parameter is invilad....{}", productVO.getProductId());
			throw new IllegalArgumentException();
		}
        
    }
    
    @ResponseBody
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public List<Product> search() throws Exception {
        LOGGER.debug("[search]------ Start : contentType= {}");
        
        return productService.search(0);
        
//        if (id != 0) {
//		} else {
//			LOGGER.error("input parameter is invilad....{}", id);
//			throw new IllegalArgumentException();
//		}
    }
    

}
