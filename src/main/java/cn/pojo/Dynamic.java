package main.java.cn.pojo;

import java.util.Date;

public class Dynamic {
    private Integer dynamic_id;
    private String user_name;
    private Date dynamic_time;
    private  String user_photo;
    private String dynamic_text;
    private  String dynamic_photo;
    private String   user_tid;
    private Integer like_count; //点赞总数
    private Integer size; //遍历一个用户是否对一个动态点赞的列表的长度
    private Integer big;  //遍历一个用户是否对一个用户关注的列表的长度
    private Integer comsun;//评论总数
    private  String dynamic_photo1;
    private  String dynamic_photo2;



    public Dynamic() {
    }

    public Dynamic(Integer dynamic_id, String user_name, Date dynamic_time, String user_photo, String dynamic_text, String dynamic_photo, String user_tid, Integer like_count, Integer size, Integer big, String dynamic_photo1, String dynamic_photo2) {
        this.dynamic_id = dynamic_id;
        this.user_name = user_name;
        this.dynamic_time = dynamic_time;
        this.user_photo = user_photo;
        this.dynamic_text = dynamic_text;
        this.dynamic_photo = dynamic_photo;
        this.user_tid = user_tid;
        this.like_count = like_count;
        this.size = size;
        this.big = big;
        this.dynamic_photo1 = dynamic_photo1;
        this.dynamic_photo2 = dynamic_photo2;
    }

    public Dynamic(String user_name, String user_photo, String dynamic_text, String dynamic_photo, String user_tid,String dynamic_photo1, String dynamic_photo2) {
        this.user_name = user_name;
        this.user_photo = user_photo;
        this.dynamic_text = dynamic_text;
        this.dynamic_photo = dynamic_photo;
        this.user_tid = user_tid;
        this.dynamic_photo1 = dynamic_photo1;
        this.dynamic_photo2 = dynamic_photo2;
    }

    public Dynamic(Integer dynamic_id, String user_name, Date dynamic_time, String user_photo, String dynamic_text, String dynamic_photo, String user_tid, Integer like_count, Integer size, Integer big, Integer comsun, String dynamic_photo1, String dynamic_photo2) {
        this.dynamic_id = dynamic_id;
        this.user_name = user_name;
        this.dynamic_time = dynamic_time;
        this.user_photo = user_photo;
        this.dynamic_text = dynamic_text;
        this.dynamic_photo = dynamic_photo;
        this.user_tid = user_tid;
        this.like_count = like_count;
        this.size = size;
        this.big = big;
        this.comsun = comsun;
        this.dynamic_photo1 = dynamic_photo1;
        this.dynamic_photo2 = dynamic_photo2;
    }

    public Integer getDynamic_id() {
        return dynamic_id;
    }

    public void setDynamic_id(Integer dynamic_id) {
        this.dynamic_id = dynamic_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getDynamic_time() {
        return dynamic_time;
    }

    public void setDynamic_time(Date dynamic_time) {
        this.dynamic_time = dynamic_time;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getDynamic_text() {
        return dynamic_text;
    }

    public void setDynamic_text(String dynamic_text) {
        this.dynamic_text = dynamic_text;
    }

    public String getDynamic_photo() {
        return dynamic_photo;
    }

    public void setDynamic_photo(String dynamic_photo) {
        this.dynamic_photo = dynamic_photo;
    }

    public String getUser_tid() {
        return user_tid;
    }

    public void setUser_tid(String user_tid) {
        this.user_tid = user_tid;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getBig() {
        return big;
    }

    public void setBig(Integer big) {
        this.big = big;
    }

    public String getDynamic_photo2() {
        return dynamic_photo2;
    }

    public void setDynamic_photo2(String dynamic_photo2) {
        this.dynamic_photo2 = dynamic_photo2;
    }

    public String getDynamic_photo1() {
        return dynamic_photo1;
    }

    public void setDynamic_photo1(String dynamic_photo1) {
        this.dynamic_photo1 = dynamic_photo1;
    }

    public Integer getComsun() {
        return comsun;
    }

    public void setComsun(Integer comsun) {
        this.comsun = comsun;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
                "dynamic_id=" + dynamic_id +
                ", user_name='" + user_name + '\'' +
                ", dynamic_time=" + dynamic_time +
                ", user_photo='" + user_photo + '\'' +
                ", dynamic_text='" + dynamic_text + '\'' +
                ", dynamic_photo='" + dynamic_photo + '\'' +
                ", user_tid='" + user_tid + '\'' +
                ", like_count=" + like_count +
                ", size=" + size +
                ", big=" + big +
                '}';
    }
}
