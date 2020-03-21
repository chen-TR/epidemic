package com.ctr.epidemic.service;

import com.ctr.epidemic.model.ProvinceInfo;

import java.util.List;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 1:20
 */
public interface ProvinceService {

    /**
     * 获取未录入数据的省份列表
     */
    List<ProvinceInfo> findNoDataProvinces(String date);
}
