package com.bnuz.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_city", schema = "hdzt")
public class CityEntity {
    @Id
    @Column(name = "city_id")
    private Long cityId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "pid")
    private Long pid;


    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (cityId != that.cityId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;

        return true;
    }

}