package com.wind.cashbook.db;

import org.litepal.crud.DataSupport;

/**
 * Created by H on 2017/11/3.
 */

public class BillDB extends DataSupport {

    private int id;
    private String money;
    private String type;
    private String date;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
