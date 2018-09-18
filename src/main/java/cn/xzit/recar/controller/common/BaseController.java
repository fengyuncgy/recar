package cn.xzit.recar.controller.common;


import cn.xzit.recar.bean.model.ResultModel;

public class BaseController {


    // 对返回数据的封装
    protected <T> ResultModel<T> success(T data) {
        return new ResultModel<>(0, "完成", data);
    }

    protected <T> ResultModel<T> success(T data,Long count) {
        return new ResultModel<>(0, "完成",count, data);
    }

    protected <T> ResultModel<T> success(String message, T data) {
        return new ResultModel<>(0, message, data);
    }

    protected <T> ResultModel<T> success(String message) {
        return new ResultModel<>(0, message, null);
    }

    protected <T> ResultModel<T> error(String message, T data) {
        return new ResultModel<>(-1, message, data);
    }

    protected <T> ResultModel<T> error(String message) {
        return new ResultModel<>(-1, message, null);
    }


    protected <T> ResultModel<T> result(Integer code, String message) {
        return new ResultModel<>(code, message, null);
    }

    protected <T> ResultModel<T> result(Integer code, String message, T data) {
        return new ResultModel<>(code, message, data);
    }
}
