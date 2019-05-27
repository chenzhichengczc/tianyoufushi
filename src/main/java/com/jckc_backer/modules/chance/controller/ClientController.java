package com.jckc_backer.modules.chance.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.chance.entity.ClientEntity;
import com.jckc_backer.modules.chance.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value="/insertClientEntity",method= RequestMethod.POST)
    public ResponseUtil insertClientEntity(ClientEntity clientEntity){
        clientService.InsertInto(clientEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/updateClientEntity",method=RequestMethod.POST)
    public ResponseUtil updateClientEntity(ClientEntity clientEntity){
        clientService.updateByUid(clientEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/deleteByClientId/{uid}",method=RequestMethod.POST)
    public ResponseUtil deleteByClientId(@PathVariable Integer uid){
        clientService.deleteByUId(uid);
        return ResponseUtil.success();
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/clientEntityList",method = RequestMethod.GET)
    public ResponseUtil clientEntityList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        EntityWrapper<ClientEntity> wrapper = new EntityWrapper<ClientEntity>();
        List<ClientEntity> pageList = clientService.getList(wrapper);
        PageInfo<ClientEntity> pageInfo=new PageInfo<>(pageList);
        return ResponseUtil.success(pageInfo);
    }
}
