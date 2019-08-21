package com.clothes.modules.score.service.impl;

import com.clothes.modules.score.mapper.ScoreMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


import com.clothes.modules.score.entity.ScoreEntity;
import com.clothes.modules.score.service.ScoreService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, ScoreEntity> implements ScoreService {

    @Resource
    private ScoreMapper scoreMapper;





    public List<ScoreEntity> scoreList(EntityWrapper<ScoreEntity> entityEntityWrapper, String openId){
        entityEntityWrapper.eq("open_id", openId);
        return  scoreMapper.selectList(entityEntityWrapper);


    }



}
