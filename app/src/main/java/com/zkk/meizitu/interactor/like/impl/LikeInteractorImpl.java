package com.zkk.meizitu.interactor.like.impl;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.GsonRequest;
import com.google.gson.reflect.TypeToken;
import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.http.instances.UriHelper;
import com.zkk.meizitu.http.instances.VolleyHelper;
import com.zkk.meizitu.interactor.like.LikeInteractor;
import com.zkk.meizitu.listeners.BaseMultiLoadedListener;

/**
 * Created by Administrator on 2016/9/15 0015.
 */
public class LikeInteractorImpl implements LikeInteractor {

    private BaseMultiLoadedListener<ImageBean> mImageBeanBaseMultiLoadedListener;

    public LikeInteractorImpl(BaseMultiLoadedListener<ImageBean> imageBeanBaseMultiLoadedListener) {
        mImageBeanBaseMultiLoadedListener = imageBeanBaseMultiLoadedListener;
    }

    @Override
    public void getCommonListData(final String requestTag, final int event_tag) {
        GsonRequest<ImageBean> gsonRequest = new GsonRequest<ImageBean>(
                UriHelper.getInstance().likes(),
                null,
                new TypeToken<ImageBean>() {
                }.getType(),
                new Response.Listener<ImageBean>() {
                    @Override
                    public void onResponse(ImageBean response) {
                        mImageBeanBaseMultiLoadedListener.onSuccess(event_tag, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mImageBeanBaseMultiLoadedListener.onException(error.getMessage());
                    }
                }
        );

        gsonRequest.setShouldCache(true);
        gsonRequest.setTag(requestTag);

        VolleyHelper.getInstance().getRequestQueue().add(gsonRequest);
    }
}
