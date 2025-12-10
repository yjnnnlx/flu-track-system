package com.zl.model;

public class Userlog {
    private Integer id;
    private String acc;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Userlog{" +
                "id=" + id +
                ", acc='" + acc + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
