package com.zl.model;

public class Nat {
    private Integer id;
    private String name;
    private Integer cid;
    private String res;
    private String ndepnam;

    private Cate cate;
    private  String Time;

    @Override
    public String toString() {
        return "Nat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                ", res='" + res + '\'' +
                ", ndepnam='" + ndepnam + '\'' +
                ", cate=" + cate +
                '}';
    }

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getNdepnam() {
        return ndepnam;
    }

    public void setNdepnam(String ndepnam) {
        this.ndepnam = ndepnam;
    }

    public Cate getCate() {
        return cate;
    }

    public void setCate(Cate cate) {
        this.cate = cate;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
