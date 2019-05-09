package com.jckc_backer.modules.information.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.jckc_backer.modules.information.entity.InformationDetailEntity;
import com.jckc_backer.modules.information.entity.InformationEntity;
import com.jckc_backer.modules.information.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/3/12 17:53
 * @description：资讯信息controller
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/information")
@Api(description = "资讯核心表")
public class InformationController {

    @Autowired
    private InformationService informationService;

    //分页
    @RequestMapping(value = "/paging",method=RequestMethod.GET)
    public com.jc.common.utils.ResponseUtil getInformationAndDetailList(int pageNum, int categoryId){
        //使用分页插件
        PageHelper.startPage(pageNum, 7);
        List<InformationDetailEntity> paging=informationService.getList(categoryId);
        PageInfo<InformationDetailEntity> pageInfo=new PageInfo<>(paging);
        return com.jc.common.utils.ResponseUtil.success(pageInfo);
    }

    @RequestMapping(value = "/getCatalogy",method = RequestMethod.GET)
    public com.jc.common.utils.ResponseUtil getCatalogy(){
        List<InformationEntity> strlist = informationService.getCatalogy();
        return com.jc.common.utils.ResponseUtil.success(strlist);
    }



    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation(value = "资讯核心列表查询", notes = "列表查询")
    public com.jc.common.utils.ResponseUtil findInformationList(int pageNo, int pageSize){
        Page<InformationEntity> page = new Page<>(pageNo, pageSize);
        EntityWrapper<InformationEntity> entityEntityWrapper = new EntityWrapper<>();
        List<InformationEntity> pageList = informationService.findByPage(page, entityEntityWrapper);
        return com.jc.common.utils.ResponseUtil.success(pageList);
    }

    //@RequestMapping(value = "/getId",method = RequestMethod.GET)
    @RequestMapping(value = "/pageList",method = RequestMethod.GET)
    public com.jc.common.utils.ResponseUtil findPage(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<InformationEntity> informationEntities = informationService.selectPage();
        PageInfo<InformationEntity> pageInfo = new PageInfo<>(informationEntities);
        return com.jc.common.utils.ResponseUtil.success(pageInfo);
    }


    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "获取单个资讯核心类型",notes = "资讯查询")
    public com.jc.common.utils.ResponseUtil selectById(@PathVariable Integer id){
        InformationEntity informationEntity = informationService.selectById(id);
        return com.jc.common.utils.ResponseUtil.success(informationEntity);
    }
    
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "新增资讯核心类型",notes = "新增")
    public com.jc.common.utils.ResponseUtil insertInfo(InformationEntity informationEntity){
        informationService.insertInfo(informationEntity);
        return com.jc.common.utils.ResponseUtil.success();
    }

    @RequestMapping(value = "/batch/insert",method = RequestMethod.POST)
    @ApiOperation(value = "批量新增资讯核心类型",notes = "批量新增")
    public com.jc.common.utils.ResponseUtil batchInsertInfo(List<InformationEntity> infoList){
        informationService.batchInsertInfo(infoList);
        return com.jc.common.utils.ResponseUtil.success();
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation(value = "更新资讯核心类型",notes = "更新")
    public com.jc.common.utils.ResponseUtil updateInfoById(InformationEntity informationEntity){
        informationService.updateInfoById(informationEntity);
        return com.jc.common.utils.ResponseUtil.success();
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除资讯核心类型",notes = "删除")
    public com.jc.common.utils.ResponseUtil deleteInfoById(@PathVariable Integer id){
        informationService.deleteInfoById(id);
        return com.jc.common.utils.ResponseUtil.success();
    }


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public com.jc.common.utils.ResponseUtil test(String typeName, String status) {
        InformationEntity test = informationService.test(typeName, status);
        return com.jc.common.utils.ResponseUtil.success(test);
    }


}
