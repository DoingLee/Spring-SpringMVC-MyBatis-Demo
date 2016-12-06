package com.my.web;

import com.my.dto.Result;
import com.my.dto.UserMsg;
import com.my.exception.InValidDeleteException;
import com.my.exception.InValidUpdateException;
import com.my.exception.RepeatInsertException;
import com.my.service.IUserService;
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

//    由于使用了@Transactional注解（会使用AOP代理），所以这里只能@Autowired接口
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/{id}/{name}/add",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> addUser(@PathVariable("id") long id, @PathVariable("name")String name){
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
    Result<UserMsg> queryUser(@PathVariable("id") long id){
        UserMsg userMsg = userService.queryById(id);
        if (userMsg == null ){
            return new Result<UserMsg>(false, null);
        }else {
            return new Result<UserMsg>(true, userMsg);
        }
    }

    @RequestMapping(value = "/{id}/{name}/update",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> updateUser(@PathVariable("id") long id, @PathVariable("name")String name){
        try {
            userService.updateUser(id, name);
            return new Result<String>(true, "更新成功！");
        }catch (InValidUpdateException e){
            return new Result<String>(false, "无效更新！");
        }
    }

    @RequestMapping(value = "/{id}/delete",
            method = RequestMethod.DELETE,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    Result<String> deleteUser(@PathVariable("id") long id){
        try {
            userService.deleteUser(id);
            return new Result<String>(true, "删除成功！");
        }catch (InValidDeleteException e){
            return new Result<String>(false, "无效删除！");
        }
    }
}
