package com.jckc_backer.modules.chance.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
        System.out.println("进来了。。。。。。。");
        chanceService.InsertInto(chanceEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public ResponseUtil updateChanceEntity(ChanceEntity chanceEntity){
        EntityWrapper<ChanceEntity> entityEntityWrapper = new EntityWrapper<>();
        chanceService.updateChanceEntity(chanceEntity,entityEntityWrapper);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public ResponseUtil deleteByChanceId(@PathVariable Integer chanceid){
        chanceService.deleteByChanceId(chanceid);
        return ResponseUtil.success();
    }

    /**
     *
     * @param pageNo 第几页
     * @param pageSize 一页多少条记录
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseUtil chanceEntityList(int pageNo, int pageSize){
        Page<ChanceEntity> page = new Page<>(pageNo, pageSize);
        EntityWrapper<ChanceEntity> chanceEntityWrapper = new EntityWrapper<>();
        List<ChanceEntity> pageList = chanceService.findByPage(page, chanceEntityWrapper);
        return ResponseUtil.success(pageList);
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public ResponseUtil selectById(@PathVariable Integer chanceid){
        ChanceEntity chanceEntity = chanceService.selectById(chanceid);
        return ResponseUtil.success(chanceEntity);
    }
}
