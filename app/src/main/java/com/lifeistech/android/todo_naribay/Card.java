package com.lifeistech.android.todo_naribay;

/**
 * Created by owner on 2018/04/22.
 */

public class Card {
    Boolean check;
    String title;

    public Card(String title) {

        this.title = title;
    }

    public String getTitleText() {
        return title;
    }

    public Boolean getCheck() {
        return check;
    }
    public void setCheck(Boolean b){
        check=b;
    }
}
