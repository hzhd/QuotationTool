package com.ruoyi.business.domain;


public class BackgroundInfo {


    private Integer id;

    private String backgroundMsg;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBackgroundMsg() {
        return backgroundMsg;
    }

    public void setBackgroundMsg(String backgroundMsg) {
        this.backgroundMsg = backgroundMsg;
    }

    public BackgroundInfo(Integer id, String backgroundMsg) {
        this.id = id;
        this.backgroundMsg = backgroundMsg;
    }

    public BackgroundInfo() {
    }

    @Override
    public String toString() {
        return "BackgroundInfo{" +
                "id=" + id +
                ", backgroundMsg='" + backgroundMsg + '\'' +
                '}';
    }
}
