package com.sql.ehr.local.exception;

/**
 * XXXXXX
 *
 * @author 沈钦林
 * @date 2021/12/10 17:54
 */
public class MyAuthenticationException extends RuntimeException{
    String msg;

    public MyAuthenticationException(String msg) {
        super(msg);
    }

    public MyAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }
}
