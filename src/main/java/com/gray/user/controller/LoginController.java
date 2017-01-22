package com.gray.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gray.annotation.Log;
import com.gray.interceptor.LogInterceptor;
import com.gray.user.entity.User;
import com.gray.user.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/test") 
public class LoginController {
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserServiceImpl userService;

@RequestMapping("/dologin.do") //url
@Log(oper="user login")
public String dologin(User user, Model model){
	logger.info("login ....");
	String info = loginUser(user);
	if (!"SUCC".equals(info)) {
		model.addAttribute("failMsg", "用户不存在或密码错误！");
		return "/jsp/fail";
	}else{
		model.addAttribute("successMsg", "登陆成功！");//返回到页面说夹带的参数
		model.addAttribute("name", user.getUsername());
		return "/jsp/success";//返回的页面
	}
  }

@RequestMapping("/logout.do")
public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
    Subject subject = SecurityUtils.getSubject();
    if (subject != null) {
    	try{
            subject.logout();
    	}catch(Exception ex){
    	}
    }
    response.sendRedirect("/index.jsp");
}

//@RequestMapping(value="/list", method=RequestMethod.GET)
//@ResponseBody
//public List<User> listData() {
//    return userService.queryAll();
//}
//@RequestMapping(value="/list/{username}", method=RequestMethod.GET)
//@ResponseBody
//public User findUserByUserName2(@PathVariable(value="username") String username) {
//	return userService.findByUserName(username);
//}

private String loginUser(User user) {
 		if (isRelogin(user)) return "SUCC"; // 如果已经登陆，无需重新登录
 		
 		return shiroLogin(user); // 调用shiro的登陆验证
}
private String shiroLogin(User user) {
		// 组装token，包括客户公司名称、简称、客户编号、用户名称；密码
	UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword().toCharArray(), null); 
	token.setRememberMe(true);
	
	// shiro登陆验证
	try {
		SecurityUtils.getSubject().login(token);
	} catch (UnknownAccountException ex) {
		return "用户不存在或者密码错误！";
	} catch (IncorrectCredentialsException ex) {
		return "用户不存在或者密码错误！";
	} catch (AuthenticationException ex) {
		return ex.getMessage(); // 自定义报错信息
	} catch (Exception ex) {
		ex.printStackTrace();
		return "内部错误，请重试！";
	}
	return "SUCC";
}

private boolean isRelogin(User user) {
	Subject us = SecurityUtils.getSubject();
		// 验证通过的时候，需要再次核对参数，如果所有参数均未改变，则无需登录（可以保持住session，避免潜在错误！！- Steven 2014-12-13）
		if (us.isAuthenticated()) {
	       return true; // 参数未改变，无需重新登录，默认为已经登录成功
		}
		return false; // 需要重新登陆
}
}
