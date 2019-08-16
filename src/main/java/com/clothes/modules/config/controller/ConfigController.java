package com.clothes.modules.config.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.config.entity.ConfigEntity;
import com.clothes.modules.config.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 *
 *
 * @author fenghuang
 * @email
 * @date 2019-08-15 16:34:48
 */
@RestController
@RequestMapping("/wx")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseUtil list(String openId, String key){
        EntityWrapper<ConfigEntity> entityEntityWrapper = new EntityWrapper<>();

        List<ConfigEntity> configEntities = configService.configList(entityEntityWrapper, key);
        return ResponseUtil.success(configEntities);
    }




}
