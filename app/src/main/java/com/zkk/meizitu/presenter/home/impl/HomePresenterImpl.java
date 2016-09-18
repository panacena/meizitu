package com.zkk.meizitu.presenter.home.impl;

import android.content.Context;

import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.http.api.Constants;
import com.zkk.meizitu.interactor.home.HomeInteractor;
import com.zkk.meizitu.interactor.home.impl.HomeInteractorImpl;
import com.zkk.meizitu.listeners.BaseMultiLoadedListener;
import com.zkk.meizitu.presenter.home.HomePresenter;
import com.zkk.meizitu.view.home.HomeView;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class HomePresenterImpl implements HomePresenter , BaseMultiLoadedListener<ImageBean> {

    private Context mContext;
    private HomeInteractor mHomeInteractor=null;
    private HomeView mHomeView;


    public HomePresenterImpl(Context context, HomeView homeView) {
        mContext = context;
        mHomeView = homeView;
        mHomeInteractor=new HomeInteractorImpl(this);
    }

    @Override
    public void loadListData(String requestTag, final int event_tag) {
        mHomeInteractor.getCommonListData(requestTag,event_tag);
    }

    @Override
    public void refreshImagesListData(String requestTag, int event_tag) {
        mHomeInteractor.refreshImagesListData(requestTag,event_tag);
    }

    @Override
    public void onSuccess(int event_tag, ImageBean data) {

        if(event_tag== Constants.EVENT_HOME_BANNER_DATA){
            mHomeView.refreshListData(data);
        }else if(event_tag== Constants.EVENT_HMOE_IMAGES_DATA){
            mHomeView.refreshImagesListData(data);
        }
    }

    @Override
    public void onError(String msg) {
        mHomeView.showError(msg);
    }

    @Override
    public void onException(String msg) {
        mHomeView.showException(msg);
    }
}
