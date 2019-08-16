package com.clothes.modules.score.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.score.entity.ScoreEntity;

import java.util.List;


/**
 *
 *
 * @author fenghuang
 * @email
 * @date 2019-08-15 16:42:53
 */
public interface ScoreService extends IService<ScoreEntity> {

    public List<ScoreEntity> scoreList(EntityWrapper<ScoreEntity> entityEntityWrapper);
}

