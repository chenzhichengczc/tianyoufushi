/*
package com.jckc_backer.modules.chance.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jckc_backer.modules.chance.entity.ClientEntity;
import com.jckc_backer.modules.chance.mapper.ClientMapper;
import com.jckc_backer.modules.chance.service.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, ClientEntity> implements ClientService {


    @Resource
    private ClientMapper clientMapper;

    @Override
    public void InsertInto(ClientEntity clientEntity) {
        clientMapper.insert(clientEntity);
    }

    @Override
    public void updateByUid(ClientEntity clientEntity) {
        clientMapper.updateById(clientEntity);
    }

    @Override
    public void deleteByUId(Integer uid) {
        clientMapper.deleteById(uid);
    }

    @Override
    public List<ClientEntity> findByPage() {
        List<ClientEntity> clientList=clientMapper.selectPage();
        return clientList;
    }

    @Override
    public List<ClientEntity> findByPage(Page<ClientEntity> page, Wrapper<ClientEntity> wrapper) {
        List<ClientEntity> clientEntitie=clientMapper.selectPage(page,wrapper);
        return clientEntitie;
    }

    @Override
    public List<ClientEntity> getList(EntityWrapper<ClientEntity> wrapper) {
        return clientMapper.selectList(wrapper);
    }


}
*/
