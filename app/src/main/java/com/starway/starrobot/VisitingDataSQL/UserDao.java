package com.starway.starrobot.VisitingDataSQL;

import android.arch.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao   //对数据库操作的一个接口。
public interface UserDao {
    @Insert
    void insertUserData(UserData...userData);

    @Delete
    void deleteUserData(UserData...userData);

    @Query("DELETE FROM USERDATA")//查询全部元素然后删除
    void deleteAllUserData();

    //@Query("SELECT * FROM USERDATA ORDER BY ID DESC")//查询全部，，，降序展示
  //  LiveData<List<UserData>> UserDataList();//将数据存储在liveData中方便于数据变化时操作
    @Query("SELECT * FROM USERDATA ORDER BY ID DESC")
    LiveData<List<UserData>> getAllUSerData();
}
