package org.wzl.videocenter.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resp<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T> Resp<T> ok() {
        return new Resp<>(200, "success", null);
    }

    public static <T> Resp<T> ok(T data) {
        return new Resp<>(200, "success", data);
    }
}
