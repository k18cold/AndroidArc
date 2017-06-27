package com.dba.ui.common;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v7.app.AppCompatActivity;

/**
 * 所有Activity的基类,用于拓展
 * Created by alan on 2017/6/9.
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity implements LifecycleRegistryOwner{

    private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    @Override
    public LifecycleRegistry getLifecycle() {
        return mLifecycleRegistry;
    }
}
