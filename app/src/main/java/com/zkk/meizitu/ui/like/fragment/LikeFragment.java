package com.zkk.meizitu.ui.like.fragment;

import android.view.View;
import android.widget.Button;

import com.github.obsessive.library.eventbus.EventCenter;
import com.huxq17.swipecardsview.SwipeCardsView;
import com.zkk.meizitu.R;
import com.zkk.meizitu.bean.ContentBean;
import com.zkk.meizitu.ui.base.BaseFragment;
import com.zkk.meizitu.ui.like.adapter.MeiziAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class LikeFragment extends BaseFragment {

    @InjectView(R.id.swipCardsView)
    SwipeCardsView swipeCardsView;
    private List<ContentBean> mList = new ArrayList<>();
    private MeiziAdapter adapter;

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
        return null;
    }

    @Override
    protected void initViewsAndEvents() {

        swipeCardsView.retainLastCard(true);
        swipeCardsView.setCardsSlideListener(new SwipeCardsView.CardsSlideListener() {
            @Override
            public void onShow(int index) {
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

        show();
    }


    /**
     * 显示cardsview
     */
    private void show() {
        if (adapter == null) {

            ContentBean contentBean=new ContentBean();
            contentBean.setUrl("http://img.mmjpg.com/small/2016/694.jpg");

            ContentBean contentBean2=new ContentBean();
            contentBean2.setUrl("http://img.mmjpg.com/small/2016/709.jpg");

            ContentBean contentBean3=new ContentBean();
            contentBean3.setUrl("http://img.mmjpg.com/small/2016/724.jpg");

            ContentBean contentBean4=new ContentBean();
            contentBean4.setUrl("http://img.mmjpg.com/small/2016/679.jpg");

            ContentBean contentBean5=new ContentBean();
            contentBean5.setUrl("http://img.mmjpg.com/small/2016/693.jpg");

            ContentBean contentBean6=new ContentBean();
            contentBean6.setUrl("http://img.mmjpg.com/small/2016/708.jpg");

            ContentBean contentBean7=new ContentBean();
            contentBean7.setUrl("http://img.mmjpg.com/small/2016/649.jpg");

            ContentBean contentBean8=new ContentBean();
            contentBean8.setUrl("http://img.mmjpg.com/small/2016/664.jpg");

            mList.add(contentBean);
            mList.add(contentBean2);
            mList.add(contentBean3);
            mList.add(contentBean4);
            mList.add(contentBean5);
            mList.add(contentBean6);
            mList.add(contentBean7);
            mList.add(contentBean8);


            mList.add(contentBean);
            mList.add(contentBean2);
            mList.add(contentBean3);
            mList.add(contentBean4);
            mList.add(contentBean5);
            mList.add(contentBean6);
            mList.add(contentBean7);
            mList.add(contentBean8);
            adapter = new MeiziAdapter(mList, getActivity());
            swipeCardsView.setAdapter(adapter);
        } else {
            //if you want to change the UI of SwipeCardsView,you must modify the data first
            adapter.setData(mList);
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
}
