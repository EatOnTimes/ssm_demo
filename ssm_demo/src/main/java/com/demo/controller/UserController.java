package com.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.demo.domain.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelAndView modelAndView;

    //保存手动返回json
    @RequestMapping(value = "/save")
    @ResponseBody //告知SpringMVC框架不进行视图跳转，直接进行数据响应
    public String save(String username,String password,Date birthday) throws JsonProcessingException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setBirthday(birthday);
        userService.save(user);
        System.out.println(user);
        //使用JSON的转换工具将对象转换成json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }
    //保存自动返回json
    @RequestMapping(value = "/saveJson")
    @ResponseBody //告知SpringMVC框架不进行视图跳转，直接进行数据响应
    public User saveJson() throws JsonProcessingException {
        User user = new User();
        user.setUsername("lisan");
        user.setPassword("123456");
        user.setBirthday(new Date());
        return user;
    }

    //查询全部
    @RequestMapping("/findAll")
    /*
            Model：模型 作用封装数据
            View： 视图 作用展示数据
         */
    public ModelAndView findAll(){
        //设置分页相关参数 当前页+每页显示的条数
        PageHelper.startPage(1,10);
        List<User> userList = userService.findAll();

        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);

        modelAndView.addObject("userList",userList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("userList");
        return modelAndView;
    }
    //id查询
    @RequestMapping(value = "/findById")
    public ModelAndView findById(@RequestParam(value = "id",required = false)int id){
        User userBy = userService.findById(id);
        modelAndView.addObject("userBy",userBy);
        modelAndView.setViewName("userList");
        return modelAndView;
    }

}
