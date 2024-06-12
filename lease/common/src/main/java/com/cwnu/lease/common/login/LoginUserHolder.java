package com.cwnu.lease.common.login;

public class LoginUserHolder {
    private static final ThreadLocal<LoginUser> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(LoginUser loginUser) {
        THREAD_LOCAL.set(loginUser);
    }

    public static LoginUser get() {
        return THREAD_LOCAL.get();
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }



}
