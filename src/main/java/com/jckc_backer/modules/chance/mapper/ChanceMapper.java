package com.jckc_backer.modules.chance.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jckc_backer.modules.chance.entity.ChanceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChanceMapper extends BaseMapper<ChanceEntity> {

      // 两表全部内容
   // List<InformationDetailEntity> findAll();

    
    List<ChanceEntity> selectPage();

    // pageHelper分页 获取
    List<ChanceEntity> getList(@Param(value = "chanceid") Integer chanceid);

}
