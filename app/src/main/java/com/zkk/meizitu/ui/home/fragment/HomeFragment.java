package com.zkk.meizitu.ui.home.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;
import com.github.obsessive.library.adapter.ListViewDataAdapter;
import com.github.obsessive.library.adapter.ViewHolderBase;
import com.github.obsessive.library.adapter.ViewHolderCreator;
import com.github.obsessive.library.eventbus.EventCenter;
import com.github.obsessive.library.pla.PLAImageView;
import com.github.obsessive.library.utils.CommonUtils;
import com.github.obsessive.library.widgets.XSwipeRefreshLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zkk.meizitu.R;
import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.http.api.Constants;
import com.zkk.meizitu.presenter.home.HomePresenter;
import com.zkk.meizitu.presenter.home.impl.HomePresenterImpl;
import com.zkk.meizitu.ui.base.BaseFragment;
import com.zkk.meizitu.view.home.HomeView;
import com.zkk.meizitu.views.PLALoadMoreListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class HomeFragment extends BaseFragment implements HomeView{


   /* @InjectView(R.id.banner)
    Banner banner;*/
    HomePresenter mHomePresenter;
    private Context mContext;

    @InjectView(R.id.fragment_images_list_swipe_layout)
    XSwipeRefreshLayout mSwipeRefreshLayout;

    @InjectView(R.id.fragment_images_list_list_view)
    PLALoadMoreListView mListView;

    private ListViewDataAdapter<ImageBean.ListsBean> mListViewAdapter = null;


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
        return mListView;
    }

    @Override
    protected void initViewsAndEvents() {

        mContext=getActivity();
        mHomePresenter=new HomePresenterImpl(mContext,this);
        //   mHomePresenter.loadListData(null, Constants.EVENT_HOME_BANNER_DATA);

        Log.d("zkk---","onFirstUserVisible");
        mHomePresenter.refreshImagesListData(null, Constants.EVENT_HMOE_IMAGES_DATA);
        Log.d("zkk---","initViewsAndEvents");
        mListViewAdapter = new ListViewDataAdapter<ImageBean.ListsBean>(new ViewHolderCreator<ImageBean.ListsBean>() {
            @Override
            public ViewHolderBase<ImageBean.ListsBean> createViewHolder(int position) {
                return new ViewHolderBase<ImageBean.ListsBean>() {

                    PLAImageView mItemImage;

                    @Override
                    public View createView(LayoutInflater layoutInflater) {
                        View convertView = layoutInflater.inflate(R.layout.list_item_images_list, null);
                        mItemImage = ButterKnife.findById(convertView, R.id.list_item_images_list_image);

                        return convertView;
                    }

                    @Override
                    public void showData(int position, ImageBean.ListsBean itemData) {
                        int width = Integer.parseInt(itemData.getWeight());
                        int height = Integer.parseInt(itemData.getHeight());

                        String imageUrl = itemData.getLink();

                        if (!CommonUtils.isEmpty(imageUrl)) {
                            Glide.with(mContext).load(imageUrl).into(mItemImage);
                          //  ImageLoader.getInstance().displayImage(imageUrl, mItemImage);
                        }

                        mItemImage.setImageWidth(width);
                        mItemImage.setImageHeight(height);
                    }
                };
            }
        });
        mListView.setAdapter(mListViewAdapter);

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home_images_list;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    public void refreshListData(ImageBean imageBean) {
       /* String[] images=new String[imageBean.getLists().size()];
        String[] titles=new String[imageBean.getLists().size()];;
        for (int i=0;i<imageBean.getLists().size();i++){
            images[i]=imageBean.getLists().get(i).getLink();
            titles[i]=imageBean.getLists().get(i).getTitle();
        }
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setDelayTime(3000);
        banner.setImages(images);
        banner.setBannerTitle(titles);*/

    }

    @Override
    public void refreshImagesListData(ImageBean imageBean) {
        Log.d("zkk---","refreshImagesListData");
        if (null != mListViewAdapter) {
            mListViewAdapter.getDataList().clear();
            mListViewAdapter.getDataList().addAll(imageBean.getLists());
            mListViewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void addMoreListData(ImageBean imageBean) {

    }
}
