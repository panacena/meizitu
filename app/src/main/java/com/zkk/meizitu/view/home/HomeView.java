package com.zkk.meizitu.view.home;

import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.view.base.BaseView;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public interface HomeView extends BaseView{

    void refreshListData(ImageBean imageBean);

    void refreshImagesListData(ImageBean imageBean);

    void addMoreListData(ImageBean imageBean);
}
