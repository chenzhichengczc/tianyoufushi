package com.clothes.modules.address.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.clothes.modules.address.entity.AddressEntity;
import org.apache.ibatis.annotations.Param;


/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-08-14 15:28:00
 */
public interface AddressMapper extends BaseMapper<AddressEntity> {

    public void updateDefault(@Param(value = "id") Integer id,
                              @Param(value = "isDefault") Integer isDefault);

    public void updateAllColumnDefault(String openId);
}
