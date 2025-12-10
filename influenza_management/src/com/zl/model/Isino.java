package com.zl.model;

public class Isino {
    private Integer id;
    private String name;
    private String idepnam;
    private String isback;
    private String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdepnam() {
        return idepnam;
    }

    public void setIdepnam(String idepnam) {
        this.idepnam = idepnam;
    }

    public String getIsback() {
        return isback;
    }

    public void setIsback(String isback) {
        this.isback = isback;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Isino{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idepnam='" + idepnam + '\'' +
                ", isback='" + isback + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
