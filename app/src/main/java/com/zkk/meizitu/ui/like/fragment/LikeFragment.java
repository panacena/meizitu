package com.zkk.meizitu.ui.like.fragment;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.github.obsessive.library.eventbus.EventCenter;
import com.huxq17.swipecardsview.LogUtil;
import com.huxq17.swipecardsview.SwipeCardsView;
import com.zkk.meizitu.R;
import com.zkk.meizitu.bean.ContentBean;
import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.http.api.Constants;
import com.zkk.meizitu.presenter.like.LikePresenter;
import com.zkk.meizitu.presenter.like.impl.LikePresenterImpl;
import com.zkk.meizitu.ui.base.BaseFragment;
import com.zkk.meizitu.ui.like.adapter.MeiziAdapter;
import com.zkk.meizitu.view.like.Likeview;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class LikeFragment extends BaseFragment implements Likeview{

    @InjectView(R.id.swipCardsView)
    SwipeCardsView swipeCardsView;
    private MeiziAdapter adapter;
    private List<ImageBean.ListsBean> mLists = new ArrayList<ImageBean.ListsBean>();
    private LikePresenter mLikePresenter;
    private Context mContext;

    private int curIndex;
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
        return swipeCardsView;
    }

    @Override
    protected void initViewsAndEvents() {
       // show();
        swipeCardsView.retainLastCard(true);
        swipeCardsView.setCardsSlideListener(new SwipeCardsView.CardsSlideListener() {
            @Override
            public void onShow(int index) {
                curIndex = index;
            }

            @Override
            public void onCardVanish(int index, SwipeCardsView.SlideType type) {
                String orientation = "";
                switch (type) {
                    case LEFT:
                        orientation = "向左飞出";
                        break;
                    case RIGHT:
                        orientation = "向右飞出";
                        break;
                }
//                toast("test position = "+index+";卡片"+orientation);
            }

            @Override
            public void onItemClick(View cardImageView, int index) {
                showToast("点击了 position=" + index);
            }
        });
        mContext=getActivity();
        mLikePresenter=new LikePresenterImpl(mContext,this);
        mLikePresenter.loadListData(null, Constants.EVENT_LIKE_DATA);

    }


    /**
     * 显示cardsview
     */
    private void show() {
        if (adapter == null) {
            adapter = new MeiziAdapter(mLists, mContext);
            swipeCardsView.setAdapter(adapter);
        } else {
            //if you want to change the UI of SwipeCardsView,you must modify the data first
            adapter.setData(mLists);
            swipeCardsView.notifyDatasetChanged(curIndex);
        }
    }
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_like;
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
       // mLists.clear();
        mLists.addAll(imageBean.getLists());
        Log.d("zkkk----",imageBean.getLists().size()+"----");
        show();
    }

}
