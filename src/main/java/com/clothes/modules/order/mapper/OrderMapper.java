package com.clothes.modules.order.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.clothes.modules.order.entity.OrderDetailEntity;
import com.clothes.modules.order.entity.OrderEntity;
import com.clothes.modules.order.entity.OrderGoodsEntity;
import com.clothes.modules.order.entity.StatisticsEntity;
import com.clothes.modules.shop.entity.ShopEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:27
 * @description：
 * @modified By：
 * @version:
 */

public interface OrderMapper extends BaseMapper<OrderEntity> {

    public List<OrderEntity> getOrderList(@Param(value = "openId") String openId,
                                          @Param(value = "status") Integer status);

    public OrderDetailEntity getOrderDetail(@Param(value = "openId") String openId,
                                           @Param(value = "id") Integer id);

    public List<OrderGoodsEntity> getOrderGoods(@Param(value = "openId") String openId,
                                                @Param(value = "id") Integer id);

    public Integer getGoodsProductId(@Param(value = "goodsId") Integer goodsId,
                                     @Param(value = "specification") String specification);

    public Integer createOrder(OrderEntity orderEntity);

    public Integer createGoodsOrder(OrderGoodsEntity orderGoodsEntity);

    public void insertVip(OrderEntity orderEntity);
}
