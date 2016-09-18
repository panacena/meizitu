package com.zkk.meizitu.ui.like.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.huxq17.swipecardsview.BaseCardAdapter;
import com.zkk.meizitu.R;
import com.zkk.meizitu.bean.ContentBean;
import com.zkk.meizitu.bean.ImageBean;

import java.util.List;


/**
 * Created by huxq17 on 2016/4/12.
 */
public class MeiziAdapter extends BaseCardAdapter {
    private List<ImageBean.ListsBean> datas;
    private Context context;

    public MeiziAdapter(List<ImageBean.ListsBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    public void setData(List<ImageBean.ListsBean> datas){
        this.datas = datas;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public int getCardLayoutId() {
        return R.layout.card_item2;
    }

    @Override
    public void onBindData(int position, View cardview) {
        if (datas == null || datas.size() == 0) {
            return;
        }
        ImageView imageView = (ImageView) cardview.findViewById(R.id.iv_meizi);
        ImageBean.ListsBean meizi = datas.get(position);
        String url = meizi.getLink();
        Glide.with(context).load(url).into(imageView);
    }

    /**
     * 如果可见的卡片数是3，则可以不用实现这个方法
     * @return
     */
    @Override
    public int getVisibleCardCount() {
        return 3;
    }
}
