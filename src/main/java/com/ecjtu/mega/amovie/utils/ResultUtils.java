package com.ecjtu.mega.amovie.utils;

import com.ecjtu.mega.amovie.entity.Result;

/**
 * @author mega
 */
public class ResultUtils {

    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(500);
        result.setMsg("失败");
        return result;
    }
}
