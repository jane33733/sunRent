package com.sun.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.request.vo.LoginVO;

@Controller
@RequestMapping(value = "login")
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 358203527105212734L;
	/** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    
    
    @ResponseBody
    @RequestMapping(value = "validate", method = RequestMethod.POST)
    public boolean loginValidate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //不推薦用restful API 座登入登出的功能，有資安風險問題
    	LOGGER.debug("[loginCheck]------ Start ");
        boolean login = false;
        System.out.println("[loginCheck]------ Start ");
        
        //檢查帳密
        System.out.println(request.getParameter("account"));
        System.out.println(request.getParameter("password"));
        
        //直接當作通過
        HttpSession session = request.getSession();
		session.setAttribute("account", request.getParameter("account"));
		session.setAttribute("name","db output name");
		
        
        return login;
    }
    
    
    @ResponseBody
    @RequestMapping(value = "validate", method = RequestMethod.POST)
    public boolean loginCheck(HttpServletRequest request,
            HttpServletResponse response, @RequestBody LoginVO queryVO) throws Exception {
        LOGGER.debug("[loginCheck]------ Start " + queryVO.getAccount());
        boolean login = false;
        System.out.println("[loginCheck]------ Start " + queryVO.getAccount());
        //直接當作通過
        HttpSession session = request.getSession();
		session.setAttribute("account",queryVO.getAccount());
		session.setAttribute("name","db output name");
		
        
        return login;
    }
}
