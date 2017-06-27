package com.dba.ui.common;

import android.arch.lifecycle.LifecycleFragment;

import com.dba.binding.FragmentDataBindingComponent;

/**
 *
 * Created by alan on 2017/6/9.
 */

public class BaseFragment extends LifecycleFragment {

    protected final android.databinding.DataBindingComponent mComponent = new FragmentDataBindingComponent(this);
}
