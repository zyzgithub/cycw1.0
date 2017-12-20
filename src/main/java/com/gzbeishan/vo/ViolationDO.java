package com.gzbeishan.vo;

import java.io.Serializable;

public class ViolationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer vId;
    private Integer carId;
    private String plateNum;
    private String decisionNumber;
    private String violationBehavior;
    private String violationLocation;
    private String siteMark;
    private String violationTime;
    private String violationPoints;
    private String violationPoints2;
    private String handledMark;
    private String finedMark;
    private String fine;
    private String violationCode;
    private String collectionOrgan;
    private String notificationNumber;
    private int valid;    //此记录是否有效，即是否已缴费

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

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

    public String getDecisionNumber() {
        return decisionNumber;
    }

    public void setDecisionNumber(String decisionNumber) {
        this.decisionNumber = decisionNumber;
    }

    public String getViolationBehavior() {
        return violationBehavior;
    }

    public void setViolationBehavior(String violationBehavior) {
        this.violationBehavior = violationBehavior;
    }

    public String getViolationLocation() {
        return violationLocation;
    }

    public void setViolationLocation(String violationLocation) {
        this.violationLocation = violationLocation;
    }

    public String getSiteMark() {
        return siteMark;
    }

    public void setSiteMark(String siteMark) {
        this.siteMark = siteMark;
    }

    public String getViolationTime() {
        return violationTime;
    }

    public void setViolationTime(String violationTime) {
        this.violationTime = violationTime;
    }

    public String getViolationPoints() {
        return violationPoints;
    }

    public void setViolationPoints(String violationPoints) {
        this.violationPoints = violationPoints;
    }

    public String getViolationPoints2() {
        return violationPoints2;
    }

    public void setViolationPoints2(String violationPoints2) {
        this.violationPoints2 = violationPoints2;
    }

    public String getHandledMark() {
        return handledMark;
    }

    public void setHandledMark(String handledMark) {
        this.handledMark = handledMark;
    }

    public String getFinedMark() {
        return finedMark;
    }

    public void setFinedMark(String finedMark) {
        this.finedMark = finedMark;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getViolationCode() {
        return violationCode;
    }

    public void setViolationCode(String violationCode) {
        this.violationCode = violationCode;
    }

    public String getCollectionOrgan() {
        return collectionOrgan;
    }

    public void setCollectionOrgan(String collectionOrgan) {
        this.collectionOrgan = collectionOrgan;
    }

    public String getNotificationNumber() {
        return notificationNumber;
    }

    public void setNotificationNumber(String notificationNumber) {
        this.notificationNumber = notificationNumber;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }
}
