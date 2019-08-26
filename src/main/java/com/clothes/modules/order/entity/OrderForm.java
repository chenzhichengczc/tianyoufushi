package com.clothes.modules.order.entity;

import lombok.Data;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/22 17:22
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class OrderForm {

    /**
     * 商品信息字符串
     */
    private String goodsJsonStr;

    /**
     * 备注
     */
    private String remark;

    /**
     * 地址id
     */
    private Integer addressId;

    /**
     *  超时时间
     */
    private Long expireMinutes;

    /**
     * 是否累计
     */
    private Boolean calculate;
}
