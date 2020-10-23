package com.starway.starrobot.activity.backstage;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.room.Room;

import com.starway.starrobot.R;
import com.starway.starrobot.VisitingDataSQL.UserDao;
import com.starway.starrobot.VisitingDataSQL.UserData;
import com.starway.starrobot.VisitingDataSQL.UserDataBase;
import com.starway.starrobot.VisitingDataSQL.VDViewModel;
import com.starway.starrobot.activity.BaseActivity;

import org.apache.ftpserver.ftplet.User;

import java.util.List;


public class VisitingDataActivity extends BaseActivity implements LifecycleObserver {
    UserDataBase dataBase;
    UserDao userDao;
    TextView textView;
    Button buttonInsert, buttonDelete;
    VDViewModel vdViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstage_vistingdata);
        buttonDelete = findViewById(R.id.buttonClear);
        buttonInsert = findViewById(R.id.buttonInsert);
        textView = findViewById(R.id.textViewShow);
        dataBase = Room.databaseBuilder(this, UserDataBase.class, "User_database")
                .allowMainThreadQueries().build();
        userDao = dataBase.getUserDao();
        vdViewModel = ViewModelProviders.of(this).get(VDViewModel.class);
        vdViewModel.getListLiveData().observe((LifecycleOwner) this, new Observer<List<UserData>>() {
            @Override
            public void onChanged(@Nullable List<UserData> userData) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < userData.size(); i++) {
                    UserData UD = userData.get(i);
                    text.append(UD.getId()).append(":").append(UD.getUSerNum()).append("\t").append(UD.getUserName()).append("\n");
                }
                textView.setText(text.toString());
            }
        });
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData userData = new UserData("jie", "123");
                userDao.insertUserData(userData);//username,id
            }
        });
    }
}
