/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zkk.meizitu.http.instances;


import com.zkk.meizitu.http.api.ApiConstants;

/**
 * Author:  Tau.Chen
 * Email:   1076559197@qq.com | tauchen1990@gmail.com
 * Date:    2015/3/20.
 * Description:
 */
public class UriHelper {

    private static volatile UriHelper instance = null;

    /**
     * 20 datas per page
     */
    public static final int PAGE_LIMIT = 20;

    public static final String URL_MUSICS_LIST_CHANNEL_ID = "0";

    private UriHelper() {
    }

    public static UriHelper getInstance() {
        if (null == instance) {
            synchronized (UriHelper.class) {
                if (null == instance) {
                    instance = new UriHelper();
                }
            }
        }
        return instance;
    }

    public int calculateTotalPages(int totalNumber) {
        if (totalNumber > 0) {
            return totalNumber % PAGE_LIMIT != 0 ? (totalNumber / PAGE_LIMIT + 1) : totalNumber / PAGE_LIMIT;
        } else {
            return 0;
        }
    }
    public String getImagesListUrl() {
        StringBuffer sb = new StringBuffer();
        sb.append(ApiConstants.MY_IMAGES_URLS);
        sb.append("CollectInfo");

        return  sb.toString();
    }


    public String  likes() {
        StringBuffer sb = new StringBuffer();
        sb.append(ApiConstants.MY_IMAGES_URLS);
        sb.append("Like");
        return  sb.toString();
    }


    public String  homeImageslikes() {
        StringBuffer sb = new StringBuffer();
        sb.append(ApiConstants.MY_IMAGES_URLS);
        sb.append("Homeimages");
        return  sb.toString();
    }

}
