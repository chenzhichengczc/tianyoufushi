package com.clothes.modules.pics.service.impl;

import com.clothes.modules.pics.entity.PicsEntity;
import com.clothes.modules.pics.mapper.PicsMapper;
import com.clothes.modules.pics.service.PicsService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;


@Service
public class PicsServiceImpl extends ServiceImpl<PicsMapper, PicsEntity> implements PicsService {

    @Resource
    private PicsMapper picsMapper;

    public List<PicsEntity> picsList(EntityWrapper<PicsEntity> entityEntityWrapper){
           return  picsMapper.selectList(entityEntityWrapper);
    }

}
