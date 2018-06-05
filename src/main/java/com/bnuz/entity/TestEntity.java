package com.bnuz.entity;


import com.bnuz.utils.serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

/**
 * Created by QuanQqqqq on 2018/4/2.
 */
@Entity
@Table(name = "t_test")
public class TestEntity {

    @Id
    @GeneratedValue
    private int id;

    private Long date;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}