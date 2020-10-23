package com.starway.starrobot.VisitingDataSQL;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import java.util.List;

public class VDViewModel extends AndroidViewModel{
    UserDao userDao;
    UserDataBase userDataBase;
    LiveData<List<UserData>>listLiveData;
    public VDViewModel(@NonNull Application application) {
        super(application);
        userDataBase=UserDataBase.getDataBase(getApplication().getApplicationContext());
        userDao=userDataBase.getUserDao();
        listLiveData=userDao.getAllUSerData();
    }
    public LiveData<List<UserData>> getListLiveData() {
        return listLiveData;
    }
    void insertUserData(UserData...userData){
    userDao.insertUserData(userData);
    }
    void deleteAllUserData(){
    userDao.deleteAllUserData();
    }
}
