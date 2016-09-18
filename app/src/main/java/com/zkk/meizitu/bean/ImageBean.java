package com.zkk.meizitu.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class ImageBean {


    /**
     * lists : [{"title":"丝袜美腿图片第7期Stephy第26张","descs":"丝袜美腿图片第7期Stephy第26张","publishtime":"None","weight":"800","webside":"None","link":"http://img.mmjpg.com/2015/104/26.jpg","ids":"http://www.mmjpg.com/mm/104","id":"6787","height":"500"},{"title":"丝袜美腿图片第7期Stephy第28张","descs":"丝袜美腿图片第7期Stephy第28张","publishtime":"None","weight":"800","webside":"None","link":"http://img.mmjpg.com/2015/104/28.jpg","ids":"http://www.mmjpg.com/mm/104","id":"6786","height":"530"},{"title":"丝袜美腿图片第7期Stephy第30张","descs":"丝袜美腿图片第7期Stephy第30张","publishtime":"None","weight":"800","webside":"None","link":"http://img.mmjpg.com/2015/104/30.jpg","ids":"http://www.mmjpg.com/mm/104","id":"6783","height":"580"}]
     * returnCode : 0000000
     */

    private String returnCode;
    /**
     * title : 丝袜美腿图片第7期Stephy第26张
     * descs : 丝袜美腿图片第7期Stephy第26张
     * publishtime : None
     * weight : 800
     * webside : None
     * link : http://img.mmjpg.com/2015/104/26.jpg
     * ids : http://www.mmjpg.com/mm/104
     * id : 6787
     * height : 500
     */

    private List<ListsBean> lists;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public List<ListsBean> getLists() {
        return lists;
    }

    public void setLists(List<ListsBean> lists) {
        this.lists = lists;
    }

    public static class ListsBean {
        private String title;
        private String descs;
        private String publishtime;
        private String weight;
        private String webside;
        private String link;
        private String ids;
        private String id;
        private String height;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescs() {
            return descs;
        }

        public void setDescs(String descs) {
            this.descs = descs;
        }

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getWebside() {
            return webside;
        }

        public void setWebside(String webside) {
            this.webside = webside;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getIds() {
            return ids;
        }

        public void setIds(String ids) {
            this.ids = ids;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }
    }
}
