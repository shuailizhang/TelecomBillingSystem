package me.tbs.zhang.entity;

/**
 * Created by dime on 16-1-5.
 */
public class Record {
    private int id;
    private String tellNumber;//本机号码
    private String date;//日期
    private float duration;//通话时长
    private boolean type;//true:长途，false:本地

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTellNumber() {
        return tellNumber;
    }

    public void setTellNumber(String tellNumber) {
        this.tellNumber = tellNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
