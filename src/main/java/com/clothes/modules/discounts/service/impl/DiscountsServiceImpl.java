package com.clothes.modules.discounts.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.common.exception.JcException;
import com.clothes.modules.coupons.entity.CouponsEntity;
import com.clothes.modules.coupons.mapper.CouponsMapper;
import com.clothes.modules.discounts.entity.DiscountsEntity;
import com.clothes.modules.discounts.mapper.DiscountsMapper;
import com.clothes.modules.discounts.service.DiscountsService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:26
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class DiscountsServiceImpl extends ServiceImpl<DiscountsMapper, DiscountsEntity> implements DiscountsService {

    @Resource
    private DiscountsMapper discountsMapper;

    @Resource
    private CouponsMapper couponsMapper;

    /**
     * 獲取公告impl 根据openid 跟状态为0的数据
     *
     * @return
     */

    public List<DiscountsEntity> discountsList(EntityWrapper<DiscountsEntity> entityEntityWrapper, String openId, Integer status) {
        entityEntityWrapper.eq("open_id", openId);
        entityEntityWrapper.eq("status", status);
        List<DiscountsEntity> discountsEntities = discountsMapper.selectList(entityEntityWrapper);
        return discountsEntities;
    }

    @Override
    public Integer fetchDiscounts(String openId, Integer id) {
        //根据Id先找寻这个用户是否已经存在这个优惠券 限定一人一张
        List<DiscountsEntity> discountsEntities = discountsMapper.selectList(new EntityWrapper<DiscountsEntity>().eq("open_id", openId).eq("coupons_id", id));
        if( discountsEntities.size() == 1 ) {
            return 20003;
        }

        //通过id 找寻数据库存的优惠券信息插入到discount表中
        CouponsEntity couponsEntity = couponsMapper.selectById(id);

        //为空 则报异常
        if(couponsEntity == null) return 500;
        //总数少于1张会返回不够兑换
        if(couponsEntity.getNumberTotle() < 1) return 20001;

        fetchUtils(openId,couponsEntity);

        return 0;
    }

    @Override
    public Integer fetch(String openId, String pwd) {
        //根据传进来的pwd查询 优惠券表的id
        List<CouponsEntity> couponsList = couponsMapper.selectList(new EntityWrapper<CouponsEntity>().eq("pwd",pwd));

        //找寻到则返回对象, 否则code = 20000
        if(couponsList.size() == 0) return 20000;

        CouponsEntity couponsEntity = couponsList.get(0);

        //根据Id先找寻这个用户是否已经存在这个优惠券 限定一人一张
        List<DiscountsEntity> discountsEntities = discountsMapper.selectList(new EntityWrapper<DiscountsEntity>().eq("open_id", openId).eq("coupons_id", couponsEntity.getId()));
        if( discountsEntities.size() == 1 ) {
            return 20003;
        }

        //总数少于1张会返回不够兑换
        if(couponsEntity.getNumberTotle() < 1) return 20001;

        fetchUtils(openId,couponsEntity);

        return 0;
    }

    public void fetchUtils(String openId,CouponsEntity couponsEntity){
        DiscountsEntity discountsEntity = new DiscountsEntity();
        discountsEntity.setCouponsId(couponsEntity.getId());
        discountsEntity.setDateEnd(couponsEntity.getDateEnd());
        discountsEntity.setMoney(couponsEntity.getMoneyMax());
        discountsEntity.setMoneyHrehold(couponsEntity.getMoneyHreshold());
        discountsEntity.setName(couponsEntity.getName());
        discountsEntity.setStatus(couponsEntity.getStatus());
        discountsEntity.setOpenId(openId);

        discountsMapper.insert(discountsEntity);

        synchronized (this){
            //同步进行更新礼券的数量
            couponsEntity.setNumberTotle( couponsEntity.getNumberTotle() - 1 );

            //修改状态
            if(couponsEntity.getNumberTotle() == 0){
                couponsEntity.setStatus(1);
                couponsEntity.setStatusStr("不正常");
            }
            couponsMapper.updateById(couponsEntity);
        }
    }

}

