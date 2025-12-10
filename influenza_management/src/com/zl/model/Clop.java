package com.zl.model;

public class Clop {
    private Integer id;
    private String name;
    private String conadd;
    private String ewdat;
    private String swdat;

    @Override
    public String toString() {
        return "Clop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", conadd='" + conadd + '\'' +
                ", ewdat='" + ewdat + '\'' +
                ", swdat='" + swdat + '\'' +
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

    public String getConadd() {
        return conadd;
    }

    public void setConadd(String conadd) {
        this.conadd = conadd;
    }

    public String getEwdat() {
        return ewdat;
    }

    public void setEwdat(String ewdat) {
        this.ewdat = ewdat;
    }

    public String getSwdat() {
        return swdat;
    }

    public void setSwdat(String swdat) {
        this.swdat = swdat;
    }
}
