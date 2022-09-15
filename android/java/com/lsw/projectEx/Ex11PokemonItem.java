package com.lsw.project4;

public class Ex11PokemonItem {
    /* 아이템의 정보를 담기 위한 클래스 */
    String num;
    String name;
    int resId, resId2;
    String tel;

    public Ex11PokemonItem(String num, String name, int resId, String tel, int resId2) {
        this.num = num;
        this.name = name;
        this.resId = resId;
        this.tel = tel;
        this.resId2 = resId2;
    }

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }
    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTel() { return tel; }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getResId2() {
        return resId2;
    }
    public void setResId2(int resId2) {
        this.resId2 = resId2;
    }
}
