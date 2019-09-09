package com.clothes.modules.shop.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.category.entity.CategoryEntity;
import com.clothes.modules.category.mapper.CategoryMapper;
import com.clothes.modules.content.entity.ContentEntity;
import com.clothes.modules.content.mapper.ContentMapper;
import com.clothes.modules.logistics.entity.LogisticsEntity;
import com.clothes.modules.logistics.mapper.LogisticsMapper;
import com.clothes.modules.pics.entity.PicsEntity;
import com.clothes.modules.pics.mapper.PicsMapper;
import com.clothes.modules.properties.entity.GoodsSpecificationEntity;
import com.clothes.modules.properties.mapper.GoodsSpecificationMapper;
import com.clothes.modules.shop.entity.ShopDetailVO;
import com.clothes.modules.shop.entity.ShopEntity;
import com.clothes.modules.shop.entity.ShopUser;
import com.clothes.modules.shop.mapper.ShopMapper;
import com.clothes.modules.shop.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, ShopEntity> implements ShopService {

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private ShopDetailVO shopDetailVO;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private PicsMapper picsMapper;

    @Resource
    private LogisticsMapper logisticsMapper;

    @Resource
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Resource
    private ContentMapper contentMapper;

    @Override
    public List<ShopEntity> getList(EntityWrapper<ShopEntity> wrapper,Integer recommendStatus) {
        List<ShopEntity> entityList=shopMapper.selectList(wrapper.eq("recommend_status",recommendStatus));
        return entityList;
    }

    @Override
    public List<ShopEntity> getUserStorage(String openId) {
        List<ShopEntity> userStorage = shopMapper.getUserStorage(openId);
        return userStorage;
    }

    @Override
    public ShopDetailVO getShopDetail(EntityWrapper<ShopEntity> wrapper, Integer id) {

        try{
            //根据传进来的id搜索当前商品
            ShopEntity shopEntity = shopMapper.selectById(id);

            //根据商品id找寻图片集合
            List<PicsEntity> picsList = picsMapper.selectList(new EntityWrapper<PicsEntity>().eq("goodsId", id));

            //获得商品的分类id,找分类表
            Integer categoryId = shopEntity.getCategoryId();
            CategoryEntity categoryEntity = categoryMapper.selectById(categoryId);

            //根据logisticsId 获取表当中物流信息
            Integer logisticsId = shopEntity.getLogisticsId();
            LogisticsEntity logisticsEntity = logisticsMapper.selectById(logisticsId);

            //根据属性id 获取商品属性集合
            Integer propertyIds = shopEntity.getPropertyIds();
            //设置content属性
            ContentEntity contentEntity = contentMapper.selectById(id);

            List<GoodsSpecificationEntity> list = new ArrayList<GoodsSpecificationEntity>();

            //找该商品的原装属性
            List<GoodsSpecificationEntity> goodsSpecificationList = goodsSpecificationMapper.selectList(new EntityWrapper<GoodsSpecificationEntity>().eq("goods_id", id).eq("sid",0));

            for (int i=0; i<goodsSpecificationList.size();i++) {
                GoodsSpecificationEntity goodsSpecificationEntity = goodsSpecificationList.get(i);
                List<GoodsSpecificationEntity> child = goodsSpecificationMapper.selectList(new EntityWrapper<GoodsSpecificationEntity>().eq("sid", goodsSpecificationEntity.getId()));
                goodsSpecificationEntity.setGoodsSpecificationEntity(child);
                list.add(goodsSpecificationEntity);
            }

            shopDetailVO.setShopEntity(shopEntity);
            shopDetailVO.setPicsEntity(picsList);
            shopDetailVO.setGoodsSpecificationEntity(list);
            shopDetailVO.setCategoryEntity(categoryEntity);
            shopDetailVO.setLogisticsEntity(logisticsEntity);
            shopDetailVO.setContentEntity(contentEntity);
            return shopDetailVO;
        }catch (Exception e){
            return new ShopDetailVO();
        }

    }
    @Override
    public void addFavShop(String openId, Integer goodsId) {
        ShopUser shopUser = new ShopUser();
        shopUser.setUserId(openId);
        shopUser.setGoodsId(goodsId);
        shopUser.setDateAdd(new Date());
        shopMapper.addFavShop(shopUser);
    }

    @Override
    public void deleteFavShop(String openId, Integer goodsId) {
        shopMapper.deleteFavShop(openId,goodsId);
    }


}
