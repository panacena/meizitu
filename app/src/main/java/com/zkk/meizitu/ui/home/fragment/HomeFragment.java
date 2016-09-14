package com.zkk.meizitu.ui.home.fragment;

import android.view.View;

import com.github.obsessive.library.eventbus.EventCenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zkk.meizitu.R;
import com.zkk.meizitu.ui.base.BaseFragment;

import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class HomeFragment extends BaseFragment {


    @InjectView(R.id.banner)
    Banner banner;
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
        String[] images= new String[] {"url"};
        String[] titles=new String[]{"标题"};
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setImages(images);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
