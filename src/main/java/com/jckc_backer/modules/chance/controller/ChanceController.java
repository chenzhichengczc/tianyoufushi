package com.jckc_backer.modules.chance.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
        System.out.println("chanceEntity = " + chanceEntity);
        chanceService.InsertInto(chanceEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
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
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseUtil chanceEntityList(){
/*        Page<ChanceEntity> page = new Page<>(pageNo, pageSize);
        EntityWrapper<ChanceEntity> chanceEntityWrapper = new EntityWrapper<>();*/
        List<ChanceEntity> pageList = chanceService.findByPage();
        return ResponseUtil.success(pageList);
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public ResponseUtil selectById(@PathVariable Integer chanceid){
        ChanceEntity chanceEntity = chanceService.selectById(chanceid);
        return ResponseUtil.success(chanceEntity);
    }
}
