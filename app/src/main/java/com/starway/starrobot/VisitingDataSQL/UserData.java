package com.starway.starrobot.VisitingDataSQL;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserData {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    @ColumnInfo(name="用户名称")
    private String UserName;
    @ColumnInfo(name="用户学号")
    private String  USerNum;

     public UserData(String userName, String userid) {
        UserName = userName;
        USerNum = userid;
    }

    public String getUSerNum() {
        return USerNum;
    }

    public void setUSerNum(String USerNum) {
        this.USerNum = USerNum;
    }

    public  UserData(){}
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

}
