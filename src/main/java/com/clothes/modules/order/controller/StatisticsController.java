package com.clothes.modules.order.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.order.entity.StatisticsEntity;
import com.clothes.modules.order.service.StatisticsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:02
 * @description：
 * @modified By：
 * @version:
 */

@RestController
@Api(tags = "公告")
@RequestMapping("/wx/api")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    /**
     * 获取订单状态
     * @return
     */
    @RequestMapping(value = "/order/statistics", method = RequestMethod.GET)
    public ResponseUtil getStatisticsList(String openId){

        EntityWrapper<StatisticsEntity> entityEntityWrapper = new EntityWrapper<>();

        List<StatisticsEntity> norderEntities = statisticsService.statisticsList(entityEntityWrapper, openId);
        return ResponseUtil.success(norderEntities);
    }


}
