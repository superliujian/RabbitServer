package org.rabbit.model;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    // peer id
    private int pid;
    private Date createdDate;

    public int getId() {
        return id;
    }

    public void setId(int uid) {
        this.id = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
