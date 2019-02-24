package com.example.administrator.smartcity.domain;

import java.util.List;

/**
 * Create by SunnyDay on 2019/02/24
 */
public class NewsCenter {

    /**
     * retcode : 200
     * data : [{"id":10000,"title":"新闻","type":1,"children":[{"id":10007,"title":"北京","type":1,"url":"/10007/list_1.json"},{"id":10006,"title":"中国","type":1,"url":"/10006/list_1.json"},{"id":10008,"title":"国际","type":1,"url":"/10008/list_1.json"},{"id":10010,"title":"体育","type":1,"url":"/10010/list_1.json"},{"id":10091,"title":"生活","type":1,"url":"/10091/list_1.json"},{"id":10012,"title":"旅游","type":1,"url":"/10012/list_1.json"},{"id":10095,"title":"科技","type":1,"url":"/10095/list_1.json"},{"id":10009,"title":"军事","type":1,"url":"/10009/list_1.json"},{"id":10093,"title":"时尚","type":1,"url":"/10093/list_1.json"},{"id":10011,"title":"财经","type":1,"url":"/10011/list_1.json"},{"id":10094,"title":"育儿","type":1,"url":"/10094/list_1.json"},{"id":10105,"title":"汽车","type":1,"url":"/10105/list_1.json"}]},{"id":10002,"title":"专题","type":10,"url":"/10006/list_1.json","url1":"/10007/list1_1.json"},{"id":10003,"title":"组图","type":2,"url":"/10008/list_1.json"},{"id":10004,"title":"互动","type":3,"excurl":"","dayurl":"","weekurl":""}]
     * extend : [10007,10006,10008,10014,10012,10091,10009,10010,10095]
     */

    private int retcode;
    private List<DataBean> data;
    private List<Integer> extend;

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<Integer> getExtend() {
        return extend;
    }

    public void setExtend(List<Integer> extend) {
        this.extend = extend;
    }

    public static class DataBean {
        /**
         * id : 10000
         * title : 新闻
         * type : 1
         * children : [{"id":10007,"title":"北京","type":1,"url":"/10007/list_1.json"},{"id":10006,"title":"中国","type":1,"url":"/10006/list_1.json"},{"id":10008,"title":"国际","type":1,"url":"/10008/list_1.json"},{"id":10010,"title":"体育","type":1,"url":"/10010/list_1.json"},{"id":10091,"title":"生活","type":1,"url":"/10091/list_1.json"},{"id":10012,"title":"旅游","type":1,"url":"/10012/list_1.json"},{"id":10095,"title":"科技","type":1,"url":"/10095/list_1.json"},{"id":10009,"title":"军事","type":1,"url":"/10009/list_1.json"},{"id":10093,"title":"时尚","type":1,"url":"/10093/list_1.json"},{"id":10011,"title":"财经","type":1,"url":"/10011/list_1.json"},{"id":10094,"title":"育儿","type":1,"url":"/10094/list_1.json"},{"id":10105,"title":"汽车","type":1,"url":"/10105/list_1.json"}]
         * url : /10006/list_1.json
         * url1 : /10007/list1_1.json
         * excurl :
         * dayurl :
         * weekurl :
         */

        private int id;
        private String title;
        private int type;
        private String url;
        private String url1;
        private String excurl;
        private String dayurl;
        private String weekurl;
        private List<ChildrenBean> children;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl1() {
            return url1;
        }

        public void setUrl1(String url1) {
            this.url1 = url1;
        }

        public String getExcurl() {
            return excurl;
        }

        public void setExcurl(String excurl) {
            this.excurl = excurl;
        }

        public String getDayurl() {
            return dayurl;
        }

        public void setDayurl(String dayurl) {
            this.dayurl = dayurl;
        }

        public String getWeekurl() {
            return weekurl;
        }

        public void setWeekurl(String weekurl) {
            this.weekurl = weekurl;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * id : 10007
             * title : 北京
             * type : 1
             * url : /10007/list_1.json
             */

            private int id;
            private String title;
            private int type;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
