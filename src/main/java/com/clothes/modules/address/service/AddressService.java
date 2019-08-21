package com.clothes.modules.address.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.clothes.modules.address.entity.AddressEntity;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 15:28:00
 */
public interface AddressService extends IService<AddressEntity> {

    public List<AddressEntity> addressList(EntityWrapper<AddressEntity> entityEntityWrapper, String openId);

    public void updateAddressById(EntityWrapper<AddressEntity> entityEntityWrapper, Integer id, Integer isDefault);

    public void deleteAddress(Integer id);

    public List<AddressEntity> getAddress(Integer id);

    public void addAddress(AddressEntity addressEntity);

    public void updateAddress(AddressEntity addressEntity);

    public AddressEntity getAddressDefault(String openId);
}

