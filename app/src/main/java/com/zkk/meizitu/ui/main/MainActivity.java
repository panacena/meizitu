package com.zkk.meizitu.ui.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.github.obsessive.library.base.BaseAppManager;
import com.github.obsessive.library.eventbus.EventCenter;
import com.github.obsessive.library.netstatus.NetUtils;
import com.zkk.meizitu.R;
import com.zkk.meizitu.ui.base.BaseActivity;
import com.zkk.meizitu.ui.home.fragment.HomeFragment;
import com.zkk.meizitu.ui.like.fragment.LikeFragment;
import com.zkk.meizitu.ui.my.fragment.MyFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

    private static long DOUBLE_CLICK_TIME = 0L;
    @InjectView(R.id.navigation_bar_home)
    Button navigation_bar_home;

    @InjectView(R.id.navigation_bar_like)
    Button navigation_bar_like;

    @InjectView(R.id.navigation_bar_my)
    Button navigation_bar_my;

    @InjectView(R.id.frame_container)
    FrameLayout frame_container;

    HomeFragment mHomeFragment;
    LikeFragment mLikeFragment;
    MyFragment  mMyFragment;
    private FragmentManager fm;
    private FragmentTransaction ft;


    @Override
    protected boolean isApplyKitKatTranslucency() {
        return false;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.navigation_bar_layout;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected View getLoadingTargetView() {
        return ButterKnife.findById(this, R.id.frame_container);
    }

    @Override
    protected void initViewsAndEvents() {
        navigation_bar_home.setOnClickListener(this);
        navigation_bar_like.setOnClickListener(this);
        navigation_bar_my.setOnClickListener(this);
        fm=getSupportFragmentManager();
        change_HomeFragment();
    }


    private void change_HomeFragment(){
        navigation_bar_home.setSelected(true);
        ft=fm.beginTransaction();
        if(mHomeFragment==null){
            mHomeFragment=new HomeFragment();
        }
        ft.replace(R.id.frame_container, mHomeFragment);
        ft.commit();
    }

    private void change_LikeFragment(){
        navigation_bar_like.setSelected(true);
        ft=fm.beginTransaction();
        if(mLikeFragment==null){
            mLikeFragment=new LikeFragment();
        }
        ft.replace(R.id.frame_container, mLikeFragment);
        ft.commit();
    }

    private void change_MyFragment(){
        navigation_bar_my.setSelected(true);
        ft=fm.beginTransaction();
        if(mMyFragment==null){
            mMyFragment=new MyFragment();
        }
        ft.replace(R.id.frame_container, mMyFragment);
        ft.commit();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.navigation_bar_home:
                navigation_bar_like.setSelected(false);
                navigation_bar_my.setSelected(false);
                change_HomeFragment();
                break;
            case R.id.navigation_bar_like:
                navigation_bar_home.setSelected(false);
                navigation_bar_my.setSelected(false);
                change_LikeFragment();
            break;
            case R.id.navigation_bar_my:
                navigation_bar_home.setSelected(false);
                navigation_bar_like.setSelected(false);
                change_MyFragment();
            break;
        }
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            return true;
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - DOUBLE_CLICK_TIME) > 2000) {
                showToast("再按一次退出..");
                DOUBLE_CLICK_TIME = System.currentTimeMillis();
            } else {
                BaseAppManager.getInstance().clear();
                System.gc();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
