package org.rabbit.model;

import java.util.Date;

public class Token {
    private String access_token;
    private long uid;
    private Date expire_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Date getExpire_in() {
        return expire_in;
    }

    public void setExpire_in(Date expire_in) {
        this.expire_in = expire_in;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
