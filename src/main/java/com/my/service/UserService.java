package com.my.service;

import com.my.dao.UserDao;
import com.my.dto.UserMsg;
import com.my.entity.User;
import com.my.exception.InValidUpdateException;
import com.my.exception.RepeatInsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Doing on 2016/12/5 0005.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    public UserService() {
    }

    @Override
    public void addUser(long id, String name) throws RepeatInsertException {
        User user = new User(id, name);
        int state = userDao.insertUser(user);

        if (state == 1){ // 插入成功
            return;
        }else { // state == 0 插入失败
            throw new RepeatInsertException("重复插入！");
        }
    }

    @Override
    public UserMsg queryById(long id) {
        User user = userDao.queryById(id);
        if (user == null){
            return null;
        }else {
            UserMsg userMsg = new UserMsg(user.getUserName(), user.getUserId());
            return userMsg;
        }
    }

    @Override
    public void updateUser(long id, String name) throws InValidUpdateException {
        int state = userDao.updateUser(id, name);
        if (state == 1){//更新成功
            return;
        } else { //state == 0 ：更新失败
            throw new InValidUpdateException("无效更新！");
        }

    }
}
