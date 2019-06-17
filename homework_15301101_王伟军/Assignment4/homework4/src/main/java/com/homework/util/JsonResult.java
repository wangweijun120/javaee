package com.homework.util;

import cn.hutool.json.JSONObject;

/**
 * @author wangweijun
 */
public class JsonResult {

    private JsonResult(){
        throw new IllegalStateException("JsonResult class");
    }

    public static String success(){
        return result(200,"success");
    }
    public static String success(Object data){
       return result(200,data);
    }

    public static String fail(){
        return result(500,"fail");
    }

    public static String fail(Object data){
        return result(500,data);
    }

    public static String result(int code,Object data){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("data",data);
        return jsonObject.toString();
    }
}
