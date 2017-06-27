package com.dba.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dba.ui.common.BaseFragment;

/**
 * 主页面
 * title:imei\version\no\wifi\btn
 * rv
 * Created by alan on 2017/6/9.
 */

public class HomeFragment extends BaseFragment {

//    AutoClearedValue<MessionFragmentBinding> mBinding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        MessionFragmentBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.mession_fragment, container, false, mComponent);
//        this.mBinding = new AutoClearedValue<>(this, dataBinding);
//        return dataBinding.getRoot();
        return new View(container.getContext());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
    }

}
