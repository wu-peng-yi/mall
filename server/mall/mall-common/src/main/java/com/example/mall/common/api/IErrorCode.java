package com.example.mall.common.api;

/**
 * @author W
 * @date 2022-02-23
 */
public interface IErrorCode {

    /**
     * 返回码
     */
    long getCode();

    /**
     * 获取返回信息
     */
    String getMessage();
}
