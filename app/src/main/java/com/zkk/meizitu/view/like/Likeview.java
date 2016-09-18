package com.zkk.meizitu.view.like;

import com.zkk.meizitu.bean.ImageBean;
import com.zkk.meizitu.view.base.BaseView;

/**
 * Created by Administrator on 2016/9/15 0015.
 */
public interface Likeview extends BaseView {

    void refreshListData(ImageBean imageBean);
}
