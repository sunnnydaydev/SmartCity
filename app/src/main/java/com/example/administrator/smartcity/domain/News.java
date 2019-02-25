package com.example.administrator.smartcity.domain;

import java.util.List;

/**
 * Create by SunnyDay on 2019/02/25
 */
public class News {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 杨幂的发际线再也回不去了么？网友吐槽像半秃
         * date : 2017-01-05 11:03
         * url : http://mini.eastday.com/mobile/170105110355287.html?qid=juheshuju
         * picture : https://03.imgmini.eastday.com/mobile/20170105/20170105110355_806f4ed3fe71d04fa452783d6736a02b_1.jpeg
         */

        private String title;
        private String date;
        private String url;
        private String picture;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
