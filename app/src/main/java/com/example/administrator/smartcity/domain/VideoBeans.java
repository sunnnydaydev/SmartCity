package com.example.administrator.smartcity.domain;

import java.util.List;

/**
 * Create by SunnyDay on 2019/02/26
 */
public class VideoBeans {

    private List<VideoBean> video;

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideoBean {
        /**
         * pictureUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551780799&di=f1e7d4f8cfc16f7159673a80f8829daf&imgtype=jpg&er=1&src=http%3A%2F%2Fi3.265g.com%2Fimages%2F201811%2F201811040442298042.jpg
         * title : LOL:IG夺冠后,Rookie说了一段话,让韩国主持人尴尬的想哭
         * from : 来源：好看视频
         * data : 发布时间：3个月前
         * jumpurl : http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4
         */

        private String pictureUrl;
        private String title;
        private String from;
        private String data;
        private String jumpurl;

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getJumpurl() {
            return jumpurl;
        }

        public void setJumpurl(String jumpurl) {
            this.jumpurl = jumpurl;
        }
    }
}
