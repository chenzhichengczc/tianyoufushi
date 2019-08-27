package com.clothes.modules.pay.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.clothes.modules.pay.entity.PayEntity;
import com.clothes.modules.pay.entity.PayReultEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/7/18 15:22
 * @description：
 * @modified By：
 * @version:
 */
public interface PayMapper extends BaseMapper<PayEntity> {

    public Integer createPayMessage(PayReultEntity payReultEntity);

    public Integer updateOrderStatus(@Param(value = "transactionId") String transactionId,
                                     @Param(value = "outTradeNo") String outTradeNo,
                                     @Param(value = "openid") String openid);
}
