package com.clothes.modules.address.controller;


import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;

import com.clothes.modules.address.entity.AddressEntity;
import com.clothes.modules.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 15:28:00
 */
@RestController
@RequestMapping("/wx")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 列表
     */
    @RequestMapping(value = "/user/shipping-address/list", method = RequestMethod.GET)
    public ResponseUtil list(String token){

        EntityWrapper<AddressEntity> entityEntityWrapper = new EntityWrapper<>();

        List<AddressEntity> addressEntities = addressService.addressList(entityEntityWrapper);
        return ResponseUtil.success(addressEntities);
    }

    @RequestMapping(value = "/user/shipping-address/updateAddressDefault", method = RequestMethod.POST)
    public ResponseUtil updateAddressById(String token, Integer id, Integer isDefault){
        System.out.println("isDefault12 = " + isDefault);
        EntityWrapper<AddressEntity> entityEntityWrapper = new EntityWrapper<>();
        addressService.updateAddressById(entityEntityWrapper, id , isDefault);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/user/shipping-address/delete", method = RequestMethod.POST)
    public ResponseUtil deleteAddress(String token, Integer id){
        addressService.deleteAddress(id );
        return ResponseUtil.success();

    }
    @RequestMapping(value = "/user/shipping-address/detail", method = RequestMethod.GET)
    public ResponseUtil getAddress(String token, Integer id){
        addressService.getAddress(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/user/shipping-address/add", method = RequestMethod.POST)
    public ResponseUtil addAddress(String token, AddressEntity addressEntity){
        addressService.addAddress(addressEntity);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/user/shipping-address/update", method = RequestMethod.POST)
    public ResponseUtil updateAddress(String token, AddressEntity addressEntity){
        addressService.updateAddress(addressEntity);
        return ResponseUtil.success();
    }

}
