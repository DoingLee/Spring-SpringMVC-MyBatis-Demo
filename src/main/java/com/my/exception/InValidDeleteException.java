package com.my.exception;

/**
 * Created by Doing on 2016/12/6 0006.
 */
public class InValidDeleteException extends DBInternalException {
    public InValidDeleteException(String message) {
        super(message);
    }

    public InValidDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
