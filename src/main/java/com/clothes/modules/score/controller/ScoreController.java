package com.clothes.modules.score.controller;

import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clothes.modules.score.entity.ScoreEntity;
import com.clothes.modules.score.service.ScoreService;




/**
 *
 *
 * @author fenghuang
 * @email
 * @date 2019-08-15 16:42:53
 */
@RestController
@RequestMapping("/wx")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 列表
     */
    @RequestMapping(value = "/score/list", method = RequestMethod.GET)
    public ResponseUtil list(){
        EntityWrapper<ScoreEntity> entityEntityWrapper = new EntityWrapper<>();

        List<ScoreEntity> scoreEntities = scoreService.scoreList(entityEntityWrapper);
        return ResponseUtil.success(scoreEntities);
    }




}
