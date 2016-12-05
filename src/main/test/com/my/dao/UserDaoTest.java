package com.my.dao;

import com.my.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Doing on 2016/12/5 0005.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testInsertUser() throws Exception {
        User user = new User(1002, "李四");
        int state = userDao.insertUser(user);
        logger.debug("插入状态：" + state); //插入成功：返回1， 插入失败（重复插入）：返回0
    }

    @Test
    public void testQueryById() throws Exception {
        User user = userDao.queryById(1003);
        logger.debug(user.toString());
    }

    @Test
    public void testUpdateUser() throws Exception {
        int state = userDao.updateUser(1005, "王五"); //把id为1003的人名更改为王五
        logger.debug("更新状态：" + state);//成功：1， 失败：0
    }
}