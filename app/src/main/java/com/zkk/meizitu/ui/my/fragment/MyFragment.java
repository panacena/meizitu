package com.zkk.meizitu.ui.my.fragment;

import android.view.View;

import com.github.obsessive.library.eventbus.EventCenter;
import com.zkk.meizitu.R;
import com.zkk.meizitu.ui.base.BaseFragment;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class MyFragment extends BaseFragment {
    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_my;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
