
package com.sun.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.request.vo.ProductQueryVO;
import com.sun.respose.vo.ProductInfoVO;
import com.sun.service.ProductService;


/**
 * The Class ImpeachController.
 */
@Controller
@RequestMapping(value = "product")
public class ProductController  {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

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
    public List<ProductInfoVO> search(@RequestBody ProductQueryVO productVO) throws Exception {
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
    public List<ProductInfoVO> search() throws Exception {
        LOGGER.debug("[search]------ Start : contentType= {}");
        List<ProductInfoVO> productList = productService.search(1);
        
        return productList;
    }
    

}
