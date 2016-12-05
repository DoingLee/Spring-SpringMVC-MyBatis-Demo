package com.my.web;

import com.my.dto.Result;
import com.my.dto.UserMsg;
import com.my.exception.InValidUpdateException;
import com.my.exception.RepeatInsertException;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Doing on 2016/12/5 0005.
 */
@Controller
@RequestMapping("/user")// restful api url:/模块/资源/{id}/细分
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{id}/add",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> addUser(@PathVariable("id") long id, @RequestParam("name")String name){
        try {
            userService.addUser(id, name);
            return new Result<String>(true, "插入成功！");
        }catch (RepeatInsertException e){
            return new Result<String>(false, "重复插入！");
        }
    }

    @RequestMapping(value = "/{id}/query",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<UserMsg> queryUser(@RequestParam("id") long id){
        UserMsg userMsg = userService.queryById(id);
        if (userMsg == null ){
            return new Result<UserMsg>(false, null);
        }else {
            return new Result<UserMsg>(true, userMsg);
        }
    }

    @RequestMapping(value = "/{id}/update",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> updateUser(@RequestParam("id") long id, @RequestParam("name")String name){
        try {
            userService.updateUser(id, name);
            return new Result<String>(true, "更新成功！");
        }catch (InValidUpdateException e){
            return new Result<String>(false, "无效更新！");
        }
    }
}
