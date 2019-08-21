package com.clothes.modules.address.service.impl;

import com.clothes.common.utils.WebGetTokenUtils;
import com.clothes.conifig.JwtConfig;
import com.clothes.modules.address.entity.AddressEntity;
import com.clothes.modules.address.mapper.AddressMapper;
import com.clothes.modules.address.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;


@Service
public class AddressServiceImpl extends ServiceImpl<com.clothes.modules.address.mapper.AddressMapper, AddressEntity> implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private JwtConfig jwtConfig;

    public List<AddressEntity> addressList(EntityWrapper<AddressEntity> entityEntityWrapper, String openId){
        entityEntityWrapper.eq("open_id",openId);
        return  addressMapper.selectList(entityEntityWrapper);
    }

    @Override
    public void updateAddressById(EntityWrapper<AddressEntity> entityEntityWrapper, Integer id, Integer isDefault) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setIsDefault(isDefault);
        entityEntityWrapper.eq("id", id);
        addressMapper.update(addressEntity, entityEntityWrapper);
    }

    @Override
    public void deleteAddress(Integer id) {
        String token = WebGetTokenUtils.getToken();
        String openId = jwtConfig.getWxOpenIdByToken(token);
        EntityWrapper<AddressEntity> entityEntityWrapper = new EntityWrapper<>();
        entityEntityWrapper.eq("id", id);
        entityEntityWrapper.eq("open_id", openId);
        addressMapper.delete(entityEntityWrapper);
    }

    @Override
    public List<AddressEntity> getAddress(Integer id) {
        EntityWrapper<AddressEntity> entityEntityWrapper = new EntityWrapper<>();
        entityEntityWrapper.eq("id", id);
        List<AddressEntity> addressEntities = addressMapper.selectList(entityEntityWrapper);
        return addressEntities;
    }

    @Override
    public void addAddress(AddressEntity addressEntity) {
        addressMapper.updateAllColumnDefault(addressEntity.getOpenId());
        addressMapper.insert(addressEntity);
    }

    @Override
    public void updateAddress(AddressEntity addressEntity) {
        EntityWrapper<AddressEntity> entityEntityWrapper = new EntityWrapper<>();
        addressMapper.updateAllColumnDefault(addressEntity.getOpenId());
        entityEntityWrapper.eq("id", addressEntity.getId());
        addressMapper.update(addressEntity, entityEntityWrapper);

    }

     @Override
    public AddressEntity getAddressDefault(String openId) {
        EntityWrapper<AddressEntity> entityEntityWrapper = new EntityWrapper<>();
        List<AddressEntity> addressEntities = addressMapper.selectList(entityEntityWrapper.eq("open_id", openId).eq("is_default", 1));
        if(addressEntities.size() != 1){
            throw new RuntimeException("查询数量有误");
        }
        return addressEntities.get(0);
    }


}
