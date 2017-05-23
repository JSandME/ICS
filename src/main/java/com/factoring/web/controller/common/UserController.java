package com.factoring.web.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import com.factoring.core.feature.cache.redis.RedisCache;
import com.factoring.core.util.JsonUtil;
import com.factoring.web.model.User;
import com.factoring.web.security.PermissionSign;
import com.factoring.web.security.RoleSign;
import com.factoring.web.service.UserService;

/**
 * 用户控制器
 * 
 * @author 
 *   
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Log logger = LogFactory.getLog(UserController.class);
	
    @Resource
    private UserService userService;

    /**
     * 用户登录
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult result, Model model, HttpServletRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();
            // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
                return "redirect:/";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", result.getFieldError().getDefaultMessage());
                return "login";
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
            // 验证成功在Session中保存用户信息
            final User authUserInfo = userService.selectByUsername(user.getUsername());
            request.getSession().setAttribute("userInfo", authUserInfo);
        } catch (AuthenticationException e) {
            // 身份验证失败
        	e.printStackTrace();
            model.addAttribute("error", "用户名或密码错误!");
            return "login";
        }
        return "redirect:/";
    }

    /**
     * 用户登出
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
    
    /**
     * 用户注册
     * @param request
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request){
    	logger.info("request.getParameter(password):" + request.getParameter("password"));
    	return "login";
    }


    /**
     * 基于角色 标识的权限控制案例
     */
    @RequestMapping(value = "/admin")
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    public String admin() {
        return "";
    }

    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String create() {
        return "";
    }
    
    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.USER_UPDATE)
    public String update() {
    	System.out.println("拥有user:update权限,能访问");
    	return "role";
    }
}
