package com.zkk.meizitu.ui.like.fragment;

import android.view.View;

import com.github.obsessive.library.eventbus.EventCenter;
import com.zkk.meizitu.R;
import com.zkk.meizitu.bean.ContentBean;
import com.zkk.meizitu.ui.base.BaseFragment;
import com.zkk.meizitu.ui.like.adapter.MeiziAdapter;
import com.zkk.meizitu.view.like.cardview.CardSlidePanel;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class LikeNewFragment extends BaseFragment {

    @InjectView(R.id.image_slide_panel)
    CardSlidePanel image_slide_panel;
    private List<ContentBean> mList = new ArrayList<>();
    private MeiziAdapter adapter;

    private CardSlidePanel.CardSwitchListener cardSwitchListener;
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

        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
            }

            @Override
            public void onCardVanish(int index, int type) {
            }

            @Override
            public void onItemClick(View cardView, int index) {
            }
        };
        image_slide_panel.setCardSwitchListener(cardSwitchListener);
        show();
        image_slide_panel.fillData(mList);

    }


    /**
     * 显示cardsview
     */
    private void show() {

            ContentBean contentBean=new ContentBean();
            contentBean.setUrl("http://img4.imgtn.bdimg.com/it/u=2494485954,147865594&fm=11&gp=0.jpg");

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
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.card_layout;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
