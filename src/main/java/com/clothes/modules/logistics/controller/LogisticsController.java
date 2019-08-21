package com.clothes.modules.logistics.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.logistics.entity.LogisticsEntity;
import com.clothes.modules.logistics.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-16 11:45:10
 */
@RestController
@RequestMapping("/wx/api")
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;

    /**
     * 列表
     */
    @RequestMapping(value = "/logistics/logisticsList", method = RequestMethod.GET)
    public ResponseUtil list(@RequestParam Map<String, Object> params){
        EntityWrapper<LogisticsEntity> entityEntityWrapper = new EntityWrapper<>();

        List<LogisticsEntity> logisticsEntities = logisticsService.logisticsList(entityEntityWrapper);
        return ResponseUtil.success(logisticsEntities);
    }




}
