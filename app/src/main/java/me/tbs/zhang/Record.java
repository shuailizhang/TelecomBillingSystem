package me.tbs.zhang;

/**
 * Created by dime on 16-1-5.
 */
public class Record {
    private String uname;
    private boolean longCall;
    private double duration;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public boolean isLongCall() {
        return longCall;
    }

    public void setLongCall(boolean longCall) {
        this.longCall = longCall;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
