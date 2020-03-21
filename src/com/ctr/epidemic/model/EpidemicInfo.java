package com.ctr.epidemic.model;

import java.util.Date;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 13:38
 */
public class EpidemicInfo {

    private Integer serialId;
    private Integer province;
    private Short dateYear,dateMonth,dateDay;
    private Integer affirmed,suspected,cured,isolated,dead;
    private Integer userId;
    private Date inputDate;

    public Integer getSerialId() {
        return serialId;
    }

    public void setSerialId(Integer serialId) {
        this.serialId = serialId;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Short getDateYear() {
        return dateYear;
    }

    public void setDateYear(Short dateYear) {
        this.dateYear = dateYear;
    }

    public Short getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(Short dateMonth) {
        this.dateMonth = dateMonth;
    }

    public Short getDateDay() {
        return dateDay;
    }

    public void setDateDay(Short dateDay) {
        this.dateDay = dateDay;
    }

    public Integer getAffirmed() {
        return affirmed;
    }

    public void setAffirmed(Integer affirmed) {
        this.affirmed = affirmed;
    }

    public Integer getSuspected() {
        return suspected;
    }

    public void setSuspected(Integer suspected) {
        this.suspected = suspected;
    }

    public Integer getCured() {
        return cured;
    }

    public void setCured(Integer cured) {
        this.cured = cured;
    }

    public Integer getIsolated() {
        return isolated;
    }

    public void setIsolated(Integer isolated) {
        this.isolated = isolated;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    @Override
    public String toString() {
        return "EpidemicInfo{" +
                "serialId=" + serialId +
                ", province=" + province +
                ", dateYear=" + dateYear +
                ", dateMonth=" + dateMonth +
                ", dateDay=" + dateDay +
                ", affirmed=" + affirmed +
                ", suspected=" + suspected +
                ", cured=" + cured +
                ", isolated=" + isolated +
                ", dead=" + dead +
                ", userId=" + userId +
                ", inputDate=" + inputDate +
                '}';
    }
}
