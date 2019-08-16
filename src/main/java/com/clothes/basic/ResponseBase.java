package com.clothes.basic;

import lombok.Data;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/16 17:44
 * @description：过滤器返回类
 * @modified By：
 * @version:
 */
@Data
public class ResponseBase {

    /**
     * 状态码
     */
    Integer code;

    /**
     * 返回信息
     */
    String msg;
}
