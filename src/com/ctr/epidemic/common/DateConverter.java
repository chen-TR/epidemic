package com.ctr.epidemic.common;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/20 20:29
 * 日期类型转换器
 */
@Component
public class DateConverter implements Converter<String, Date> {

    private static Logger logger = Logger.getLogger(DateConverter.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String s) {
        if (s==null||s.length()==0) {
            return null;
        }
        Date date = null;

        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            logger.error("转换参数"+ s + "为日期类型数据时出错："+e.getMessage());
        }

        return date;
    }
}
