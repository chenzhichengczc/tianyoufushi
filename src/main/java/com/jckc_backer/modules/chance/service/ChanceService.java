package com.jckc_backer.modules.chance.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.modules.chance.entity.ChanceEntity;
import com.jckc_backer.modules.information.entity.InformationDetailEntity;
import com.jckc_backer.modules.information.entity.InformationEntity;

import java.util.List;


public interface ChanceService extends IService<ChanceEntity> {

    void InsertInto(ChanceEntity chanceEntity);


    void updateChanceEntity(ChanceEntity chanceEntity, EntityWrapper<ChanceEntity> entityEntityWrapper);

    void deleteByChanceId(Integer chanceid);

    /**
     * 分页查询
     * @param ：page,queryWrapper
     */
    List<ChanceEntity> findByPage(Page<ChanceEntity> page, Wrapper<ChanceEntity> wrapper);

    /**
     * 使用pagehelper分页
     */
    List<ChanceEntity> getList(Integer chanceid);


    List<ChanceEntity> selectPage();
}
