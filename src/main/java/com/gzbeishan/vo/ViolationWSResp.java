package com.gzbeishan.vo;

import java.util.List;

public class ViolationWSResp {

    //车辆状态：是否办理违章
    private CarStatus carStatus;

    //现场违章
    private List<ViolationDO> site;

    //非现场违章
    private List<ViolationDO> offSite;

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public List<ViolationDO> getSite() {
        return site;
    }

    public void setSite(List<ViolationDO> site) {
        this.site = site;
    }

    public List<ViolationDO> getOffSite() {
        return offSite;
    }

    public void setOffSite(List<ViolationDO> offSite) {
        this.offSite = offSite;
    }
}
