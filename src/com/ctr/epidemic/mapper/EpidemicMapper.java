package com.ctr.epidemic.mapper;

import com.ctr.epidemic.model.EpidemicInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 13:54
 */
@Mapper
public interface EpidemicMapper {

    //@Insert()
    int save(EpidemicInfo epidemicInfo);
}
