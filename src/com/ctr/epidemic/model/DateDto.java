package com.ctr.epidemic.model;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 1:55
 * 日期传输对象
 */
public class DateDto {
    private short year;
    private short month;
    private short date;

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public short getDate() {
        return date;
    }

    public void setDate(short date) {
        this.date = date;
    }
}
