package com.jia.ren.shiro.pojo;

public class User {
    private Integer id;
    private String userName;
    private String password;
    private String remarks;

    public User(Integer id, String userName, String password, String remarks) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.remarks = remarks;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
