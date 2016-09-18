package com.zkk.meizitu.ui.home.fragment;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
import com.zkk.meizitu.R;
import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.http.api.Constants;
import com.zkk.meizitu.presenter.home.HomePresenter;
import com.zkk.meizitu.presenter.home.impl.HomePresenterImpl;
import com.zkk.meizitu.ui.base.BaseFragment;
import com.zkk.meizitu.ui.home.adapter.PhotoListAdapter;
import com.zkk.meizitu.view.home.HomeView;
import com.zkk.meizitu.views.PLALoadMoreListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class HomeNewFragment extends BaseFragment implements HomeView{


   /* @InjectView(R.id.banner)
    Banner banner;*/
    HomePresenter mHomePresenter;
    private Context mContext;


    @InjectView(R.id.photo_rv)
    RecyclerView mPhotoRv;

    PhotoListAdapter mPhotoListAdapter;

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
        return mPhotoRv;
    }

    @Override
    protected void initViewsAndEvents() {
     mContext=getActivity();
     mPhotoListAdapter=new PhotoListAdapter(mContext);
     mPhotoRv.setHasFixedSize(true);
     mPhotoRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
     mPhotoRv.setItemAnimator(new DefaultItemAnimator());
     mPhotoRv.setAdapter(mPhotoListAdapter);

        mHomePresenter=new HomePresenterImpl(mContext,this);
        //   mHomePresenter.loadListData(null, Constants.EVENT_HOME_BANNER_DATA);
        Log.d("zkk---","onFirstUserVisible");
        mHomePresenter.refreshImagesListData(null, Constants.EVENT_HMOE_IMAGES_DATA);

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_content_photo;
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

      mPhotoListAdapter.setList(imageBean.getLists());
      mPhotoListAdapter.notifyDataSetChanged();
    }

    @Override
    public void addMoreListData(ImageBean imageBean) {

    }
}
