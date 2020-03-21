package com.ctr.epidemic.service.impl;

import com.ctr.epidemic.common.DateUtil;
import com.ctr.epidemic.mapper.EpidemicMapper;
import com.ctr.epidemic.model.DailyEpidemicDto;
import com.ctr.epidemic.model.DateDto;
import com.ctr.epidemic.model.EpidemicInfo;
import com.ctr.epidemic.model.ProvinceInfo;
import com.ctr.epidemic.service.EpidemicService;
import com.ctr.epidemic.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 13:54
 */
@Service
public class EpidemicServiceImpl implements EpidemicService {

    @Autowired
    private EpidemicMapper epidemicMapper;

    @Autowired
    private ProvinceService provinceService;

    @Override
    public List<ProvinceInfo> saveData(DailyEpidemicDto dailyEpidemicDto,Integer userId) {

        Date current = new Date();

        DateDto dateDto = DateUtil.parseDate(dailyEpidemicDto.getDate());
        for (EpidemicInfo epidemicInfo:dailyEpidemicDto.getArray()
             ) {
            epidemicInfo.setUserId(userId);
            epidemicInfo.setInputDate(current);
            epidemicInfo.setDateYear(dateDto.getYear());
            epidemicInfo.setDateMonth(dateDto.getMonth());
            epidemicInfo.setDateDay(dateDto.getDate());
            epidemicMapper.save(epidemicInfo);
        }

        return provinceService.findNoDataProvinces(dailyEpidemicDto.getDate());
    }
}
