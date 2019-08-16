package com.clothes.modules.address.service.impl;

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





    public List<AddressEntity> addressList(EntityWrapper<AddressEntity> entityEntityWrapper, String openId){
            entityEntityWrapper.eq("open_id",openId);
           return  addressMapper.selectList(entityEntityWrapper);


    }

    @Override
    public void updateAddressById(EntityWrapper<AddressEntity> entityEntityWrapper, Integer id, Integer isDefault) {
        System.out.println("isDefault = " + isDefault);
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setIsDefault(isDefault);

        entityEntityWrapper.eq("id", id);

        addressMapper.update(addressEntity, entityEntityWrapper);
    }

    @Override
    public void deleteAddress(Integer id) {

        EntityWrapper<AddressEntity> entityEntityWrapper = new EntityWrapper<>();
        entityEntityWrapper.eq("id", id);
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

        addressMapper.insert(addressEntity);
    }

    @Override
    public void updateAddress(AddressEntity addressEntity) {
        EntityWrapper<AddressEntity> entityEntityWrapper = new EntityWrapper<>();
        entityEntityWrapper.eq("id", addressEntity.getId());
        addressMapper.update(addressEntity, entityEntityWrapper);

    }


}
