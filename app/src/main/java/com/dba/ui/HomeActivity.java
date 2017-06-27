package com.dba.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dba.R;
import com.dba.ui.common.BaseActivity;

/**
 * ActionBar被动刷新, 包含Imei, 机架号, wifi, version
 * Created by alan on 2017/6/9.
 */

public class HomeActivity extends BaseActivity {

    private NavigationController mNavigationController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null){
            if (mNavigationController == null){
                mNavigationController = new NavigationController(this);
                mNavigationController.navigateToHome();
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    public NavigationController getNavigationController(){
        return mNavigationController;
    }
}
