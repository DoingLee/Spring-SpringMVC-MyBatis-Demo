package com.my.exception;

/**
 * Created by Doing on 2016/12/5 0005.
 */

/**
 * 无效更新异常类
 */
public class InValidUpdateException extends DBInternalException
{
    public InValidUpdateException(String message) {
        super(message);
    }

    public InValidUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
