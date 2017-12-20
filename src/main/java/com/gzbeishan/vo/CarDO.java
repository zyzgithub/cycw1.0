package com.gzbeishan.vo;

import java.io.Serializable;

public class CarDO implements Serializable {


    private static final long serialVersionUID = 1L;

    private Integer carId;
    private String plateNum;    //车牌号
    private String plateType;    //车牌类型
    private String engine;        //发动机号
    private String vin;            //车架号

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getPlateType() {
        return plateType;
    }

    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
