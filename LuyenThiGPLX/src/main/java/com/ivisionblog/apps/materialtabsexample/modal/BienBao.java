package com.ivisionblog.apps.materialtabsexample.modal;


public class BienBao {
    private String mName;
    private String mContent;
    private int mhinh;
    public int getMhinh() {
        return mhinh;
    }

    public void setMhinh(int mhinh) {
        this.mhinh = mhinh;
    }

    public BienBao(String name, String content, int hinh){
        mName = name;
        mContent = content;
        mhinh = hinh;

    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }
}
