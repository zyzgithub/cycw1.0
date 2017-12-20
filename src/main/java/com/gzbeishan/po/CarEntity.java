package com.gzbeishan.po;

import javax.persistence.*;

/**
 * Created by zhangyong on 2017/12/13.
 */
@Entity
@Table(name = "cheyou.car")
public class CarEntity {
    private int id;
    private String plateNum;
    private Integer plateType;
    private String engine;
    private String vim;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "plate_num")
    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    @Basic
    @Column(name = "plate_type")
    public Integer getPlateType() {
        return plateType;
    }

    public void setPlateType(Integer plateType) {
        this.plateType = plateType;
    }

    @Basic
    @Column(name = "engine")
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Basic
    @Column(name = "vim")
    public String getVim() {
        return vim;
    }

    public void setVim(String vim) {
        this.vim = vim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarEntity that = (CarEntity) o;

        if (id != that.id) return false;
        if (plateNum != null ? !plateNum.equals(that.plateNum) : that.plateNum != null) return false;
        if (plateType != null ? !plateType.equals(that.plateType) : that.plateType != null) return false;
        if (engine != null ? !engine.equals(that.engine) : that.engine != null) return false;
        if (vim != null ? !vim.equals(that.vim) : that.vim != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (plateNum != null ? plateNum.hashCode() : 0);
        result = 31 * result + (plateType != null ? plateType.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (vim != null ? vim.hashCode() : 0);
        return result;
    }
}
