package me.tbs.zhang.entity;

import java.util.Date;

/**
 * Created by dime on 16-1-5.
 */
public class Record {
    private int id;
    private String tel;//本机号码
    private Date date;
    private float duration;//通话时长
    private boolean type;//true:长途，false:本地

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

}
