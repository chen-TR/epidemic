package com.ctr.epidemic.mapper;

import com.ctr.epidemic.model.DateDto;
import com.ctr.epidemic.model.ProvinceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 1:30
 */
@Mapper
public interface ProvinceMapper {

    @Select("SELECT  p.province_id ,p.province_name ,p.province_py " +
            "FROM `provinces` p " +
            "WHERE p.del_flag IS NULL OR p.del_flag=0 " +
            "AND p.province_id NOT IN( " +
            "SELECT e.province " +
            "FROM epidemics e " +
            "WHERE e.date_year=#{year} AND e.date_month=#{month} AND e.date_day=#{date}" +
            ") ORDER BY p.province_id " +
            "LIMIT 0,6")
    List<ProvinceInfo> findNoDataProvinces(DateDto dateDto);
}
