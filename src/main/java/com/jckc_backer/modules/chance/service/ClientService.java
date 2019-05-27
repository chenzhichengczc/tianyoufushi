package com.jckc_backer.modules.chance.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.modules.chance.entity.ChanceEntity;
import com.jckc_backer.modules.chance.entity.ClientEntity;
import com.jckc_backer.modules.information.entity.InformationEntity;

import java.util.List;


public interface ClientService extends IService<ClientEntity> {

    void InsertInto(ClientEntity clientEntity);

    void updateByUid(ClientEntity clientEntity);

  //  void updateChanceEntity(ChanceEntity chanceEntity, EntityWrapper<ChanceEntity> entityEntityWrapper);

    void deleteByUId(Integer uid);

    /**
     * 分页查询
     * @param ：page,queryWrapper
     */
    List<ClientEntity> findByPage();

    List<ClientEntity> findByPage(Page<ClientEntity> page, Wrapper<ClientEntity> wrapper);
    /**
     * 使用pagehelper分页
     */
    List<ClientEntity> getList(EntityWrapper<ClientEntity> wrapper);

}
