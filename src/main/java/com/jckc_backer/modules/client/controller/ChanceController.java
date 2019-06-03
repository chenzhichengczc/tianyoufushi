package com.jckc_backer.modules.client.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.client.entity.ChanceEntity;
import com.jckc_backer.modules.client.service.ChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/chance")
public class ChanceController{

    @Autowired
    private ChanceService chanceService;

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public ResponseUtil insertChanceEntity(ChanceEntity chanceEntity){
        chanceService.insertChance(chanceEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    public ResponseUtil updateChanceEntity(ChanceEntity chanceEntity){
        chanceService.updateChance(chanceEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value="/delete/{chanceid}",method=RequestMethod.POST)
    public ResponseUtil deleteByChanceId(@PathVariable Integer chanceid){
        chanceService.deleteById(chanceid);
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
