package com.ctr.epidemic.service;

import com.ctr.epidemic.model.DailyEpidemicDto;
import com.ctr.epidemic.model.ProvinceInfo;
import org.apache.ibatis.ognl.ListPropertyAccessor;

import java.util.List;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 13:51
 */

public interface EpidemicService {

    /**
     *保存录入数据，获取下一批待录入数据
     *
     * @param dailyEpidemicDto
     * @return
     */
    List<ProvinceInfo> saveData(DailyEpidemicDto dailyEpidemicDto,Integer userId);
}
