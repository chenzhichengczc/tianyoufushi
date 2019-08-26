package com.clothes.modules.order.service.impl;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.common.exception.JcException;
import com.clothes.common.utils.OrderStatusUtils;
import com.clothes.common.utils.WebGetTokenUtils;
import com.clothes.conifig.JwtConfig;
import com.clothes.modules.order.entity.OrderDetailEntity;
import com.clothes.modules.order.entity.OrderEntity;
import com.clothes.modules.order.entity.OrderForm;
import com.clothes.modules.order.entity.OrderGoodsEntity;
import com.clothes.modules.order.mapper.OrderMapper;
import com.clothes.modules.order.service.OrderService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/20 17:26
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private JwtConfig jwtConfig;

    /**
     * 根据订单状态获取当前订单
     * @param openId
     * @param status
     * @return
     */
    public List<OrderEntity> orderList(String openId, Integer status) {
        List<OrderEntity> orderList = orderMapper.getOrderList(openId, status);
        return orderList;
    }

    /**
     * 根据订单Id获取订单详情
     * @param openId
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getOrderDetail(String openId, Integer id) {
        Map<String, Object> map = new HashMap<>();
        List<OrderGoodsEntity> orderGoods = orderMapper.getOrderGoods(openId, id);
        System.out.println("orderGoods = " + orderGoods);
        map.put("goods", orderGoods);
        OrderDetailEntity orderDetail = orderMapper.getOrderDetail(openId, id);
        if(orderDetail == null){
            throw new JcException("查看订单详情失败");
        }
        String statusStr = OrderStatusUtils.statusStr[orderDetail.getStatus()];
        map.put("statusStr", statusStr);

        map.put("orderInfo", orderDetail);

        return map;
    }

    /**
     * 生成入订单
     * @param orderForm
     * @return
     */
    @Override
    public Map<String, Object> insertForm(OrderForm orderForm) {

        System.out.println("orderForm.getGoodsJsonStr() = " + orderForm.getGoodsJsonStr());
        //解析JSON字符串
        JSONArray jsonArray = JSON.parseArray(orderForm.getGoodsJsonStr());
        System.out.println("jsonObject = " + jsonArray);
        if(jsonArray == null){
            throw new JcException("商品选择有误");
        }
//        "[{\"goodsId\":115780,\"number\":1,
//         \"propertyChildIds\":\"10529:3,\",\"logisticsType\":0, \"inviter_id\":0},
//         {\"goodsId\":115780,\"number\":2,
//         \"propertyChildIds\":\"10529:4,\",\"logisticsType\":0, \"inviter_id\":0}]"

        OrderEntity orderEntity = new OrderEntity();
        //判断是否有payId已支付，若有已付款，没有则未支付
        //if(payId != null && payId == ""){
        //    orderEntity.setStatus(1);
        //}
        //获取订单号
        orderEntity.setOrderOn(orderForm.getOrderOn());
        orderEntity.setRemark(orderForm.getRemark());
        orderEntity.setGoodsPrice(orderForm.getGoodsPrice());
        //获取用户openId
        String openId = jwtConfig.getWxOpenIdByToken(WebGetTokenUtils.getToken());
        orderEntity.setOpenId(openId);
        orderEntity.setAddressId(orderForm.getAddressId());
        orderEntity.setActualPrice(orderForm.getActualPrice());
        orderEntity.setPayId(orderForm.getPayId());
        //生成订单表,获取当前订单表id
        Integer orderId = orderMapper.createOrder(orderEntity);
        if(orderId == null || orderId == -1){
            throw new JcException("数据插入失败");
        }
        for(int i=0; i< jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Integer goodsId = (Integer) jsonObject.get("goodsId");
            Integer number = (Integer) jsonObject.get("number");
            String specifications =  (String)jsonObject.get("specifications");
            Integer logisticsType = (Integer) jsonObject.get("logisticsType");
            Integer inviter_id= (Integer) jsonObject.get("inviter_id");
            System.out.println("specifications = " + specifications);
            Integer goodsProductId = orderMapper.getGoodsProductId(goodsId, specifications);
            if(goodsProductId == null){
                throw new JcException("查不到对应的商品货品");
            }
            OrderGoodsEntity orderGoodsEntity = new OrderGoodsEntity();
            orderGoodsEntity.setOrderId(orderId);
            orderGoodsEntity.setGoodsId(goodsId);
            orderGoodsEntity.setNumber(number);
            orderGoodsEntity.setSpecification(specifications);
            Integer goodsOrder = orderMapper.createGoodsOrder(orderGoodsEntity);
            if(goodsOrder == null || goodsOrder != 1){
                throw new JcException("数据插入失败");
            }

        }

        return null;
    }
}
