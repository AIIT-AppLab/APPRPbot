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
    private String  UserId;

     UserData(String userName, String userId) {
        UserName = userName;
        UserId = userId;
    }
    UserData(){}
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

     String getUserName() {
        return UserName;
    }

     void setUserName(String userName) {
        UserName = userName;
    }

     String getUserId() {
        return UserId;
    }

     void setUserId(String userId) {
        UserId = userId;
    }
}
