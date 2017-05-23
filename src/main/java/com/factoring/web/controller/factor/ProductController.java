package com.factoring.web.controller.factor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @author 
 *   
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/page")
    public String login() {
        return "product";
    }

    

}