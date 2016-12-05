package com.my.service;

/**
 * Created by Doing on 2016/12/5 0005.
 */

import com.my.dto.UserMsg;
import com.my.exception.InValidUpdateException;
import com.my.exception.RepeatInsertException;

/**
 * 业务接口:站在"使用者"角度设计接口
 * 三个方面:方法定义粒度,参数,返回类型(return 类型/异常)
 */
public interface IUserService {
    /**
     * @param id 插入id
     * @param name 插入名字
     * @throws RepeatInsertException 重复插入异常
     */
    void addUser(long id, String name) throws RepeatInsertException;

    /**
     * @param id 根据id查询
     * @return null：查询失败
     */
    UserMsg queryById(long id);

    /**
     * @param id 根据id更新
     * @param name 更新的名字
     * @throws InValidUpdateException 无效更新（id不存在）
     */
    void updateUser(long id, String name) throws InValidUpdateException;
}
