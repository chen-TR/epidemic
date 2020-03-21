package com.ctr.epidemic.model;

import java.util.List;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 13:41
 */
public class DailyEpidemicDto {

    private String date;
    private List<EpidemicInfo> array;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<EpidemicInfo> getArray() {
        return array;
    }

    public void setArray(List<EpidemicInfo> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "DailyEpidemicDto{" +
                "date='" + date + '\'' +
                ", array=" + array +
                '}';
    }
}
