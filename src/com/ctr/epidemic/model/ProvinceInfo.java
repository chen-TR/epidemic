package com.ctr.epidemic.model;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 1:15
 */
public class ProvinceInfo {
    private Integer provinceId;
    private String provinceName;
    private String provincePinYing;

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvincePinYing() {
        return provincePinYing;
    }

    public void setProvincePinYing(String provincePinYing) {
        this.provincePinYing = provincePinYing;
    }
}
