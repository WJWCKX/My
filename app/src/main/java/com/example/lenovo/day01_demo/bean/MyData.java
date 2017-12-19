package com.example.lenovo.day01_demo.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/18.
 */

public class MyData {


    private List<InfoListBean> infoList;

    public List<InfoListBean> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<InfoListBean> infoList) {
        this.infoList = infoList;
    }

    public static class InfoListBean {
        /**
         * img : http://img.juhe.cn/joke/201412/19/B9EBF01A3C718DABB4C166356CC839A8.jpg
         * type : 1
         * goods_name : 音乐枕头
         * integral : 100
         * likes : 293
         */

        private String img;
        private String type;
        private String goods_name;
        private String integral;
        private String likes;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getLikes() {
            return likes;
        }

        public void setLikes(String likes) {
            this.likes = likes;
        }
    }
}
