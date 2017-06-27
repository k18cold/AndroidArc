package com.dba.ui;

import android.support.v4.app.FragmentManager;

import com.dba.R;
import com.dba.ui.common.BaseFragment;

/**
 *
 * Created by alan on 2017/6/9.
 */

public class NavigationController {

    private final int mContainerId;
    private final FragmentManager mFragmentManager;
    private BaseFragment mCurFragment;

    public NavigationController(HomeActivity activity){
        this.mContainerId = R.id.container;
        this.mFragmentManager = activity.getSupportFragmentManager();
    }

    public BaseFragment getCurFragment(){
        return mCurFragment;
    }

    public void navigateToHome(){
        mCurFragment = new HomeFragment();
        mFragmentManager.beginTransaction()
                .replace(mContainerId, mCurFragment)
                .commitAllowingStateLoss();
    }
}
