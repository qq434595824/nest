package com.ziyan.errors;

/**
 * Created by ziyan on 17/5/6.
 */
public enum ErrorCode {
    system_error(0, "系统错误"),
    invalid_params(1, "非法参数"),
    verify_failed(2, "验证码错误，请重新输入"),
    pwd_check_failed(3, "用户名或密码错误，请重新输入"),
    create_data_failed(4, "创建数据失败"),
    get_configure_file_faile(5, "获取配置文件失败"),
    merge_template_faile(6, "渲染模板失败"),
    locked_user(7, "账号已被锁定,请联系管理员"),
    captha_error(8, "验证码不正确");

    private ErrorCode(int code, String message) {
        this.code = code + offset;
        this.message = message;
    }

    private int code;
    private String message;
    private static final int offset = 10000;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
