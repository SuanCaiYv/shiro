package com.learn.shiro.result;

/**
 * @author SuanCaiYv
 * @time 2020/6/12 上午9:18
 */
public class ResultBean<T> {

    private int code = 0;

    private String msg = "";

    private T data = null;

    public static final int UNSIGNED_USER = -1;

    public static final int INCORRECT_PASSWORD = 1;

    public static final int ALL_PASSED = 0;

    public static final int LOCKED_USER = 2;

    public static final int STU_USER = 11;

    public static final int COM_USER = 12;

    public static final int TEA_USER = 13;

    public static final int HED_USER = 14;

    public static final int ACCESS_DENIED = 21;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
