package com.jckc_backer.modules.chance.service.impl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jckc_backer.modules.chance.entity.ChanceEntity;
import com.jckc_backer.modules.chance.mapper.ChanceMapper;
import com.jckc_backer.modules.chance.service.ChanceService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ChanceServiceImpl extends ServiceImpl<ChanceMapper,ChanceEntity> implements ChanceService {


    @Resource
    private ChanceMapper chanceMapper;

    @Override
    public void InsertInto(ChanceEntity chanceEntity) {
        chanceMapper.insert(chanceEntity);
    }

    @Override
    public void updateChanceEntity(ChanceEntity chanceEntity, EntityWrapper<ChanceEntity> wrapper) {
        chanceMapper.update(chanceEntity,wrapper);
    }

    @Override
    public void deleteByChanceId(Integer chanceid) {
        chanceMapper.deleteById(chanceid);
    }

    @Override
    public List<ChanceEntity> findByPage(Page<ChanceEntity> page, Wrapper<ChanceEntity> wrapper) {
        List<ChanceEntity> chanceList=chanceMapper.selectPage(page,wrapper);
        return chanceList;
    }

    @Override
    public List<ChanceEntity> getList(Integer chanceid) {
        return chanceMapper.getList(chanceid);
    }

    @Override
    public List<ChanceEntity> selectPage() {
        List<ChanceEntity> ChanceEntities = chanceMapper.selectPage();
        return ChanceEntities;
    }


}
