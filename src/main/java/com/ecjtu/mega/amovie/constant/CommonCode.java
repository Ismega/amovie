package com.ecjtu.mega.amovie.constant;

import com.ecjtu.mega.amovie.entity.Result;

/**
 * @author mega
 */
public class CommonCode {

    /**
     * 成功
     *
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    /**
     * 请求失败
     *
     * @param message
     * @return
     */
    public static Result error(String message) {
        Result result = new Result();
        result.setMsg(message);
        result.setCode(400);
        return result;
    }

    public static Result notfound(String message) {
        Result result = new Result();
        result.setMsg(message);
        result.setCode(404);
        return result;
    }
}
