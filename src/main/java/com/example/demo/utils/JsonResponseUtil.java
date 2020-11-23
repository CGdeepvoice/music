package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonResponseUtil {
    public static JSONObject success(String msg){
        JSONObject response = new JSONObject();
        response.put("code", 1);
        response.put("msg", msg);
        return response;
    }

    public static JSONObject error(String msg){
        JSONObject response = new JSONObject();
        response.put("code", 0);
        response.put("msg", msg);
        return response;
    }

    public static JSONObject uploadSuccess(String path, String msg){
        JSONObject response = new JSONObject();
        response.put("code", 1);
        response.put("path", path);
        response.put("msg", msg);
        return response;
    }
}
