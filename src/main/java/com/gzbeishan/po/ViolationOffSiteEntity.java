package com.gzbeishan.po;

import javax.persistence.*;

/**
 * Created by zhangyong on 2017/12/13.
 */
@Entity
@Table(name = "cheyou_violation_off_site", schema = "cheyou")
public class ViolationOffSiteEntity {
    private int id;
    private Integer carId;
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
    //1 未付款 0 已付款
    private Integer valid;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "car_id")
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "decision_number")
    public String getDecisionNumber() {
        return decisionNumber;
    }

    public void setDecisionNumber(String decisionNumber) {
        this.decisionNumber = decisionNumber;
    }

    @Basic
    @Column(name = "violation_behavior")
    public String getViolationBehavior() {
        return violationBehavior;
    }

    public void setViolationBehavior(String violationBehavior) {
        this.violationBehavior = violationBehavior;
    }

    @Basic
    @Column(name = "violation_location")
    public String getViolationLocation() {
        return violationLocation;
    }

    public void setViolationLocation(String violationLocation) {
        this.violationLocation = violationLocation;
    }

    @Basic
    @Column(name = "site_mark")
    public String getSiteMark() {
        return siteMark;
    }

    public void setSiteMark(String siteMark) {
        this.siteMark = siteMark;
    }

    @Basic
    @Column(name = "violation_time")
    public String getViolationTime() {
        return violationTime;
    }

    public void setViolationTime(String violationTime) {
        this.violationTime = violationTime;
    }

    @Basic
    @Column(name = "violation_points")
    public String getViolationPoints() {
        return violationPoints;
    }

    public void setViolationPoints(String violationPoints) {
        this.violationPoints = violationPoints;
    }

    @Basic
    @Column(name = "violation_points2")
    public String getViolationPoints2() {
        return violationPoints2;
    }

    public void setViolationPoints2(String violationPoints2) {
        this.violationPoints2 = violationPoints2;
    }

    @Basic
    @Column(name = "handled_mark")
    public String getHandledMark() {
        return handledMark;
    }

    public void setHandledMark(String handledMark) {
        this.handledMark = handledMark;
    }

    @Basic
    @Column(name = "fined_mark")
    public String getFinedMark() {
        return finedMark;
    }

    public void setFinedMark(String finedMark) {
        this.finedMark = finedMark;
    }

    @Basic
    @Column(name = "fine")
    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    @Basic
    @Column(name = "violation_code")
    public String getViolationCode() {
        return violationCode;
    }

    public void setViolationCode(String violationCode) {
        this.violationCode = violationCode;
    }

    @Basic
    @Column(name = "collection_organ")
    public String getCollectionOrgan() {
        return collectionOrgan;
    }

    public void setCollectionOrgan(String collectionOrgan) {
        this.collectionOrgan = collectionOrgan;
    }

    @Basic
    @Column(name = "notification_number")
    public String getNotificationNumber() {
        return notificationNumber;
    }

    public void setNotificationNumber(String notificationNumber) {
        this.notificationNumber = notificationNumber;
    }

    @Basic
    @Column(name = "valid")
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViolationOffSiteEntity that = (ViolationOffSiteEntity) o;

        if (id != that.id) return false;
        if (carId != null ? !carId.equals(that.carId) : that.carId != null) return false;
        if (decisionNumber != null ? !decisionNumber.equals(that.decisionNumber) : that.decisionNumber != null)
            return false;
        if (violationBehavior != null ? !violationBehavior.equals(that.violationBehavior) : that.violationBehavior != null)
            return false;
        if (violationLocation != null ? !violationLocation.equals(that.violationLocation) : that.violationLocation != null)
            return false;
        if (siteMark != null ? !siteMark.equals(that.siteMark) : that.siteMark != null) return false;
        if (violationTime != null ? !violationTime.equals(that.violationTime) : that.violationTime != null)
            return false;
        if (violationPoints != null ? !violationPoints.equals(that.violationPoints) : that.violationPoints != null)
            return false;
        if (violationPoints2 != null ? !violationPoints2.equals(that.violationPoints2) : that.violationPoints2 != null)
            return false;
        if (handledMark != null ? !handledMark.equals(that.handledMark) : that.handledMark != null) return false;
        if (finedMark != null ? !finedMark.equals(that.finedMark) : that.finedMark != null) return false;
        if (fine != null ? !fine.equals(that.fine) : that.fine != null) return false;
        if (violationCode != null ? !violationCode.equals(that.violationCode) : that.violationCode != null)
            return false;
        if (collectionOrgan != null ? !collectionOrgan.equals(that.collectionOrgan) : that.collectionOrgan != null)
            return false;
        if (notificationNumber != null ? !notificationNumber.equals(that.notificationNumber) : that.notificationNumber != null)
            return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (carId != null ? carId.hashCode() : 0);
        result = 31 * result + (decisionNumber != null ? decisionNumber.hashCode() : 0);
        result = 31 * result + (violationBehavior != null ? violationBehavior.hashCode() : 0);
        result = 31 * result + (violationLocation != null ? violationLocation.hashCode() : 0);
        result = 31 * result + (siteMark != null ? siteMark.hashCode() : 0);
        result = 31 * result + (violationTime != null ? violationTime.hashCode() : 0);
        result = 31 * result + (violationPoints != null ? violationPoints.hashCode() : 0);
        result = 31 * result + (violationPoints2 != null ? violationPoints2.hashCode() : 0);
        result = 31 * result + (handledMark != null ? handledMark.hashCode() : 0);
        result = 31 * result + (finedMark != null ? finedMark.hashCode() : 0);
        result = 31 * result + (fine != null ? fine.hashCode() : 0);
        result = 31 * result + (violationCode != null ? violationCode.hashCode() : 0);
        result = 31 * result + (collectionOrgan != null ? collectionOrgan.hashCode() : 0);
        result = 31 * result + (notificationNumber != null ? notificationNumber.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        return result;
    }
}
