package com.ctr.epidemic.common;

import com.ctr.epidemic.model.DateDto;
import org.apache.log4j.Logger;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 1:57
 */
public class DateUtil {

    private static Logger logger = Logger.getLogger(DateUtil.class);

    public static DateDto parseDate(String date){
        DateDto dateDto = new DateDto();
        String[] array = date.split("-");
        if (array.length==3){
            dateDto.setYear(Short.parseShort(array[0]));
            dateDto.setMonth(Short.parseShort(array[1]));
            dateDto.setDate(Short.parseShort(array[2]));
        }else logger.error("日期参数有误");

        return dateDto;
    }
}
