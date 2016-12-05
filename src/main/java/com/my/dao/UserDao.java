package com.my.dao;

import com.my.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Doing on 2016/12/5 0005.
 */
@Repository
public interface UserDao {

    /**
     * @param user
     * @return 1：插入成功； 0：插入失败（重复插入）（由mybatis和mysql自动处理）
     */
    int insertUser(User user);

    //单参数
    /**
     * @param id 根据id查找
     * @return
     */
    User queryById(long id);

    //多参数
    /**
     * @param id 根据id更改
     * @param name 新的名字
     * @return 1：更新成功； 0：更新失败（更新的行不存在）（由mybatis和mysql自动处理）
     */
    int updateUser(@Param("id")long id, @Param("name")String name);
}
