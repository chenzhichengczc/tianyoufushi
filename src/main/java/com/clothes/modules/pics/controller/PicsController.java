package com.clothes.modules.pics.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.clothes.modules.pics.entity.PicsEntity;
import com.clothes.modules.pics.service.PicsService;




/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-16 11:17:09
 */
@RestController
@RequestMapping("/wx/api")
public class PicsController {
    @Autowired
    private PicsService picsService;

    /**
     * 列表
     */
    @RequestMapping(value = "/pics/picsList", method = RequestMethod.GET)
    public ResponseUtil list(@RequestParam Map<String, Object> params){
        EntityWrapper<PicsEntity> entityEntityWrapper = new EntityWrapper<>();
        List<PicsEntity> picsEntities = picsService.picsList(entityEntityWrapper);
        return ResponseUtil.success(picsEntities);
    }




}
