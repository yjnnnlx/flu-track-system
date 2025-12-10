package com.zl.model;

public class Pat {
    private Integer id;
    private String name;
    private String address;
    private String makeTime;
    private String state;

    @Override
    public String toString() {
        return "Pat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", makeTime='" + makeTime + '\'' +
                ", state='" + state + '\'' +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(String makeTime) {
        this.makeTime = makeTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
