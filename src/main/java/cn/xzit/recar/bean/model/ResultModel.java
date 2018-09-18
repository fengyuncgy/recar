package cn.xzit.recar.bean.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultModel<T> implements Serializable {
    private Integer code;
    private String message;
    private Long count;
    private T data;
    private String url;

    public ResultModel(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultModel(Integer code, String message, Long count, T data) {
        this.code = code;
        this.message = message;
        this.count = count;
        this.data = data;
    }
}
