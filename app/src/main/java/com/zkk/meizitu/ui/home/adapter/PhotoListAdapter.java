/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zkk.meizitu.ui.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.zkk.meizitu.R;
import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.ui.base.BaseRecyclerViewAdapter;
import com.zkk.meizitu.utils.DimenUtil;
import com.zkk.meizitu.views.RatioImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import application.MeizituApplication;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author 咖枯
 * @version 1.0 2016/8/7
 */
public class PhotoListAdapter extends BaseRecyclerViewAdapter<ImageBean.ListsBean> {

    private int width = (int) (DimenUtil.getScreenSize() / 2);

    private Map<Integer, Integer> mHeights = new HashMap<>();
    Context mContext;

    public PhotoListAdapter(Context context) {
        super(null);
        mContext=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_FOOTER:
                view = getView(parent, R.layout.item_news_footer);
                return new FooterViewHolder(view);
            case TYPE_ITEM:
                view = getView(parent, R.layout.item_photo);
                final ItemViewHolder itemViewHolder = new ItemViewHolder(view);
//                itemViewHolder.setIsRecyclable(false);
                setItemOnClickEvent(itemViewHolder);
                return itemViewHolder;
            default:
                throw new RuntimeException("there is no type that matches the type " +
                        viewType + " + make sure your using types correctly");
        }

    }

    private void setItemOnClickEvent(final RecyclerView.ViewHolder holder) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        super.onBindViewHolder(holder, position);
        if (holder instanceof ItemViewHolder) {
//            ((ItemViewHolder) holder).mPhotoIv.setOriginalSize(width, getHeight(position));

/*            SimpleTarget<Bitmap> simpleTarget = new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    ((ItemViewHolder) holder).mPhotoIv.setOriginalSize(resource.getWidth(), resource.getHeight());
                    ((ItemViewHolder) holder).mPhotoIv.setImageBitmap(resource);
                }
            };*/  // 加载图片后设置实际图片宽高比，由于加载图片耗时，使用瀑布流比较混乱，容易重叠错位

/*            Glide.with(App.getAppContext())
                    .load(mList.get(position).getUrl())
//                    .asBitmap()*//*.format(DecodeFormat.PREFER_ARGB_8888)*//* // 没有动画
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade()
                    .placeholder(R.color.image_place_holder)
                    .error(R.drawable.ic_load_fail)
//                    .into(simpleTarget);
                    .into(((ItemViewHolder) holder).mPhotoIv);*/
            float f = Float.valueOf(mList.get(position).getWeight()).floatValue() / Float.valueOf(mList.get(position).getHeight());
            int i = (int)(DimenUtil.getScreenSize()/2 / f);
            ViewGroup.LayoutParams layoutParams = ((ItemViewHolder) holder).mPhotoIv.getLayoutParams();
            layoutParams.width = DimenUtil.getScreenSize()/2;
            layoutParams.height = i;
            ((ItemViewHolder) holder).mPhotoIv.setLayoutParams(layoutParams);

            Glide.with(mContext).load(mList.get(position).getLink()).into(((ItemViewHolder) holder).mPhotoIv);


            // 使用picasso加载图片可以自动计算图片实际宽高比进行设置，刷新也不会出现闪屏现象！
        }

        // 使用动画效果，当滑动过快时会引起item重叠，除了不是用动画，暂还没有想到更好的方法解决此冲突问题！
        // 跳转到图片详情有时共享动画会卡着不动，点一下屏幕才恢复
//        setItemAppearAnimation(holder, position, R.anim.anim_rotate_scale_in);
    }


    private int getHeight(int position) {
        int height;
        try {
            if (position >= mHeights.size()) {
                height = getRandomHeight();
                mHeights.put(position, height);
            } else {
                height = mHeights.get(position);
            }
        } catch (Exception e) {
            height = width / 2;
        }
        return height;
    }

    private int getRandomHeight() {
        int height;
        height = (int) (width * (new Random().nextFloat() / 2 + 1));
        return height;
    }

    @Override
    public int getItemViewType(int position) {
        if (mIsShowFooter && isFooterPosition(position)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.photo_iv)
        RatioImageView mPhotoIv;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
