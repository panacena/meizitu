package com.zkk.meizitu.interactor.home.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.GsonRequest;
import com.google.gson.reflect.TypeToken;
import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.http.instances.UriHelper;
import com.zkk.meizitu.http.instances.VolleyHelper;
import com.zkk.meizitu.interactor.home.HomeInteractor;
import com.zkk.meizitu.listeners.BaseMultiLoadedListener;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class HomeInteractorImpl implements HomeInteractor {

    private BaseMultiLoadedListener<ImageBean> mBaseMultiLoadedListener=null;

    public HomeInteractorImpl(BaseMultiLoadedListener<ImageBean> baseMultiLoadedListener) {
        mBaseMultiLoadedListener = baseMultiLoadedListener;
    }

    @Override
    public void getCommonListData(String requestTag, final int event_tag) {
        GsonRequest<ImageBean> gsonRequest = new GsonRequest<ImageBean>(
                UriHelper.getInstance().getImagesListUrl(),
                null,
                new TypeToken<ImageBean>() {
                }.getType(),
                new Response.Listener<ImageBean>() {
                    @Override
                    public void onResponse(ImageBean response) {
                        mBaseMultiLoadedListener.onSuccess(event_tag, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mBaseMultiLoadedListener.onException(error.getMessage());
                    }
                }
        );

        gsonRequest.setShouldCache(true);
        gsonRequest.setTag(requestTag);

        VolleyHelper.getInstance().getRequestQueue().add(gsonRequest);
    }

    @Override
    public void refreshImagesListData(String requestTag, final int event_tag) {
        GsonRequest<ImageBean> gsonRequest = new GsonRequest<ImageBean>(
                UriHelper.getInstance().homeImageslikes(),
                null,
                new TypeToken<ImageBean>() {
                }.getType(),
                new Response.Listener<ImageBean>() {
                    @Override
                    public void onResponse(ImageBean response) {
                        mBaseMultiLoadedListener.onSuccess(event_tag, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mBaseMultiLoadedListener.onException(error.getMessage());
                    }
                }
        );

        gsonRequest.setShouldCache(true);
        gsonRequest.setTag(requestTag);

        VolleyHelper.getInstance().getRequestQueue().add(gsonRequest);
    }
}
