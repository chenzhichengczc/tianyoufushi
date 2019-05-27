package com.jckc_backer.modules.chance.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jckc_backer.modules.chance.entity.ChanceEntity;

import java.util.List;

public interface ChanceMapper extends BaseMapper<ChanceEntity> {
    
    List<ChanceEntity> selectPage();

    // pageHelper分页 获取
    List<ChanceEntity> getList();


}
