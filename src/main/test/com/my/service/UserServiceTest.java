package com.my.service;

import com.my.dto.UserMsg;
import com.my.exception.InValidUpdateException;
import com.my.exception.RepeatInsertException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Doing on 2016/12/5 0005.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml" , "classpath:spring/spring-service.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testAddUser(){
        try {
            userService.addUser(1004, "张一");
            logger.debug("插入成功");
        }catch (RepeatInsertException e){
            logger.debug("重复插入");
        }
    }

    @Test
    public void testQueryById(){
        UserMsg userMsg = userService.queryById(1004);
        if (userMsg != null){
            logger.debug("查找成功");
            logger.debug(userMsg.toString());
        }else {
            logger.debug("查找失败");
        }
    }

    @Test
    public void testUpdateUser() {
        try {
            userService.updateUser(1006, "张二");
            logger.debug("更新成功");
        }catch (InValidUpdateException e ) {
            logger.debug("无效更新");
        }
    }
}