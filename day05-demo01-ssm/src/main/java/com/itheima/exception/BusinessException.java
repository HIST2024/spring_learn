package com.itheima.exception;

/**
 * @author codermao
 * @date 2023/3/5 12:27
 */
//自定义异常处理器，用于封装异常信息，对异常进行分类
public class BusinessException extends RuntimeException {
    /*
    * code:状态码
    * message：异常信息（在父类中）
    * */
    private Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
