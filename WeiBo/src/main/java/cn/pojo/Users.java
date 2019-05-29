package main.java.cn.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Users {
    private String user_tel;
    private String user_name;
    private Integer user_sex;
    private String user_intro;
    private Date user_rtime;
    private String user_email;
    private String user_qq;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date user_birth;
    private Integer user_age;
    private String user_pass;
    private String user_photo;
    private Integer follow_count;   //用户关注总数
    private Integer fans_count;     //用户粉丝总数
    private Integer leng;          //遍历一个用户是否对一个用户关注的列表的长度
    private Integer dynamic_count;  //用户发布动态总数


    public Users() {
    }


    public Users(String user_tel, String user_name, Integer user_sex, String user_intro, Date user_rtime, String user_email, String user_qq, Date user_birth, Integer user_age, String user_pass, String user_photo, Integer follow_count, Integer fans_count, Integer leng, Integer dynamic_count) {
        this.user_tel = user_tel;
        this.user_name = user_name;
        this.user_sex = user_sex;
        this.user_intro = user_intro;
        this.user_rtime = user_rtime;
        this.user_email = user_email;
        this.user_qq = user_qq;
        this.user_birth = user_birth;
        this.user_age = user_age;
        this.user_pass = user_pass;
        this.user_photo = user_photo;
        this.follow_count = follow_count;
        this.fans_count = fans_count;
        this.leng = leng;
        this.dynamic_count = dynamic_count;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_tel='" + user_tel + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_sex=" + user_sex +
                ", user_intro='" + user_intro + '\'' +
                ", user_rtime=" + user_rtime +
                ", user_email='" + user_email + '\'' +
                ", user_qq='" + user_qq + '\'' +
                ", user_birth=" + user_birth +
                ", user_age=" + user_age +
                ", user_pass='" + user_pass + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", follow_count=" + follow_count +
                ", fans_count=" + fans_count +
                ", leng=" + leng +
                ", dynamic_count=" + dynamic_count +
                '}';
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    public Integer getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(Integer user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_intro() {
        return user_intro;
    }

    public void setUser_intro(String user_intro) {
        this.user_intro = user_intro;
    }

    public Date getUser_rtime() {
        return user_rtime;
    }

    public void setUser_rtime(Date user_rtime) {
        this.user_rtime = user_rtime;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public Date getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(Date user_birth) {
        this.user_birth = user_birth;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public Integer getFollow_count() {
        return follow_count;
    }

    public void setFollow_count(Integer follow_count) {
        this.follow_count = follow_count;
    }

    public Integer getFans_count() {
        return fans_count;
    }

    public void setFans_count(Integer fans_count) {
        this.fans_count = fans_count;
    }

    public Integer getLeng() {
        return leng;
    }

    public void setLeng(Integer leng) {
        this.leng = leng;
    }

    public Integer getDynamic_count() {
        return dynamic_count;
    }

    public void setDynamic_count(Integer dynamic_count) {
        this.dynamic_count = dynamic_count;
    }

}
