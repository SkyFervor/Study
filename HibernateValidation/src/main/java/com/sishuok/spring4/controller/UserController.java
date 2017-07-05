package com.sishuok.spring4.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sishuok.spring4.entity.User;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-12-13
 * <p>Version: 1.0
 */
@Controller
public class UserController {

    @RequestMapping("/save")
    @ResponseBody
    public String save(@Valid User user, BindingResult result) {
    	JSON.toJSONString(result);
        if(result.hasErrors()) {
            return "failure";
        }
        return "success";
    }

    @RequestMapping("/ajax")
    @ResponseBody
    public Object ajaxError(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "failure";
        }
        return "success";
    }


    @RequestMapping("/register")
    public String register(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "error";
        }
        return "success";
    }

}
