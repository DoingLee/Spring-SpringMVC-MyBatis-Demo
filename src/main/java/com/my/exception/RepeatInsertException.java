package com.my.exception;

/**
 * Created by Doing on 2016/12/5 0005.
 */

/**
 * 重复添加数据异常类
 */
public class RepeatInsertException extends DBInternalException {
    public RepeatInsertException (String message) {
        super(message);
    }

    public RepeatInsertException (String message, Throwable cause) {
        super(message, cause);
    }
}
