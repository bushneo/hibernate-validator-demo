package com.bushneo.validator.utils;

/**
 * 验证消息throw模式
 */
public interface MsgThrowMode {

    /**
     * 不throw,拼接后返回所有验证消息
     */
     int NOT_THROW = 0;
    
    /**
     * throw所有
     */
    int THROW_ALL = 1;
    
    /**
     * throw第一条
     */
    int THROW_ONE = 2;
}
