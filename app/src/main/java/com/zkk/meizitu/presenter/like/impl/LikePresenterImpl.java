package com.zkk.meizitu.presenter.like.impl;

import android.content.Context;

import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.http.api.Constants;
import com.zkk.meizitu.interactor.like.LikeInteractor;
import com.zkk.meizitu.interactor.like.impl.LikeInteractorImpl;
import com.zkk.meizitu.listeners.BaseMultiLoadedListener;
import com.zkk.meizitu.presenter.like.LikePresenter;
import com.zkk.meizitu.view.like.Likeview;

/**
 * Created by Administrator on 2016/9/15 0015.
 */
public class LikePresenterImpl implements LikePresenter,BaseMultiLoadedListener<ImageBean>{

    private Context mContext;
    private Likeview mLikeview;
    private LikeInteractor mLikeInteractor;

    public LikePresenterImpl(Context context, Likeview likeview) {
        mContext = context;
        mLikeview = likeview;
        mLikeInteractor=new LikeInteractorImpl(this);
    }

    @Override
    public void onSuccess(int event_tag, ImageBean data) {
        if(event_tag== Constants.EVENT_LIKE_DATA){
            mLikeview.refreshListData(data);
        }
    }

    @Override
    public void onError(String msg) {
        mLikeview.showError(msg);
    }

    @Override
    public void onException(String msg) {
        mLikeview.showError(msg);
    }

    @Override
    public void loadListData(String requestTag, int event_tag) {
        mLikeInteractor.getCommonListData(requestTag,event_tag);
    }
}
