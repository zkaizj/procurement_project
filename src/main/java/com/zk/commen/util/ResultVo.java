package com.zk.commen.util;

import lombok.Data;

/**
 * @author ZK
 * @date 2023/4/18 21:01
 * @description ReturnObj
 */
@Data
public class ResultVo<T> {
    private String errorMessage;
    private boolean success;
    private T data;

    public static ResultVo error(String message){
        ResultVo returnObj = new ResultVo<>();
        returnObj.setSuccess(false);
        returnObj.setErrorMessage(message);
        return returnObj;
    }
//    public static ResultVo successMessage(String message){
//        ResultVo returnObj = new ResultVo<>();
//        returnObj.setSuccess(true);
//        returnObj.setMessage(message);
//        return returnObj;
//    }

    public static<T> ResultVo<T> success(T data) {
        ResultVo<T> returnObj = new ResultVo<>();
        returnObj.setSuccess(true);
        returnObj.setData(data);
        return returnObj;
    }
    public static<T> ResultVo<T> success() {
        ResultVo<T> returnObj = new ResultVo<>();
        returnObj.setSuccess(true);
        return returnObj;
    }
}
