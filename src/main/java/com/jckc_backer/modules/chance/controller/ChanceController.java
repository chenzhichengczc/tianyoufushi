package com.jckc_backer.modules.chance.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.chance.entity.ChanceEntity;
import com.jckc_backer.modules.chance.service.ChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chance")
public class ChanceController{

    @Autowired
    private ChanceService chanceService;

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public ResponseUtil insertChanceEntity(ChanceEntity chanceEntity){
        chanceService.InsertInto(chanceEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    public ResponseUtil updateChanceEntity(ChanceEntity chanceEntity){
        chanceService.updateByChacneid(chanceEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/delete/{chanceid}",method=RequestMethod.POST)
    public ResponseUtil deleteByChanceId(@PathVariable Integer chanceid){
        chanceService.deleteByChanceId(chanceid);
        return ResponseUtil.success();
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseUtil chanceEntityList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        EntityWrapper<ChanceEntity> wrapper = new EntityWrapper<ChanceEntity>();
        List<ChanceEntity> pageList = chanceService.getList(wrapper);
        PageInfo<ChanceEntity> pageInfo=new PageInfo<>(pageList);
        return ResponseUtil.success(pageInfo);
    }

}
