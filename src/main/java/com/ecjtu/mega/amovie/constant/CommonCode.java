package com.ecjtu.mega.amovie.constant;

import com.ecjtu.mega.amovie.entity.Result;

public class CommonCode {

    //成功
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }
//    public final static int OK = 200;

    //失败
    public static Result error() {
        Result result = new Result();
        result.setCode(400);
        result.setMsg("失败");
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.setCode(400);
        result.setMsg(message);
        return result;
    }
//    public final static int ERROR = 400;
}
