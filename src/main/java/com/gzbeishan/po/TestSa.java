package com.gzbeishan.po;

import javax.persistence.*;

/**
 * Created by zhangyong on 2017/12/18.
 */

@Entity
@Table(name = "cheyou.test")
public class TestSa {



    public  Integer id;

    public  String name;


    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
