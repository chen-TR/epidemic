package com.ctr.epidemic.service.impl;

import com.ctr.epidemic.common.DateUtil;
import com.ctr.epidemic.mapper.ProvinceMapper;
import com.ctr.epidemic.model.DateDto;
import com.ctr.epidemic.model.ProvinceInfo;
import com.ctr.epidemic.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 1:21
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<ProvinceInfo> findNoDataProvinces(String date) {

        //解析日期字符串
        DateDto dateDto = DateUtil.parseDate(date);
        List<ProvinceInfo> list = null;
        list = provinceMapper.findNoDataProvinces(dateDto);
        return list;
    }
}
