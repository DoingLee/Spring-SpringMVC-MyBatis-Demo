package com.my.exception;

/**
 * Created by Doing on 2016/12/5 0005.
 */

/**
 * 数据库内部异常类
 */
public class DBInternalException extends RuntimeException{
        public DBInternalException(String message) {
            super(message);
        }

        public DBInternalException(String message, Throwable cause) {
            super(message, cause);
        }
}
