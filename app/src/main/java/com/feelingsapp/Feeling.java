package com.feelingsapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity
public class Feeling {

    @PrimaryKey(autoGenerate = true)
    private int Id;

    @NonNull
    @ColumnInfo(name = "name")
    private String Name;

    @ColumnInfo(name = "date")
    private Long Data;

    @ColumnInfo(name = "message")
    private String Message;

    public Feeling() {}

    public Feeling(String name, String message){
        this.Name = name;
        this.Message = message;
        this.Data = System.currentTimeMillis();
    }
    /* Getters */
    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Long getData() {
        return Data;
    }

    public String getMessage() {
        return Message;
    }

    /* Setters */
    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setData(Long data) {
        Data = data;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
