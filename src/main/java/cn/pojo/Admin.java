package main.java.cn.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//管理员表
public class Admin {
    private String admin_count;
    private String admin_pass;
    private String admin_name;
    private Integer admin_level;
    private String admin_card;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date admin_login;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date admin_out;
    private String admin_photo;
    private Integer admin_id;
    private Integer categoryLevel1;
    private Integer categoryLevel2;
    private String categoryLevel1Name;//所属一级分类名称
    private String categoryLevel2Name;//所属二级分类名称

    public Admin() {
    }

    public Admin(String admin_count, String admin_pass, String admin_name, Integer admin_level, String admin_card, Date admin_login, Date admin_out, String admin_photo, Integer admin_id, Integer categoryLevel1, Integer categoryLevel2, String categoryLevel1Name, String categoryLevel2Name) {
        this.admin_count = admin_count;
        this.admin_pass = admin_pass;
        this.admin_name = admin_name;
        this.admin_level = admin_level;
        this.admin_card = admin_card;
        this.admin_login = admin_login;
        this.admin_out = admin_out;
        this.admin_photo = admin_photo;
        this.admin_id = admin_id;
        this.categoryLevel1 = categoryLevel1;
        this.categoryLevel2 = categoryLevel2;
        this.categoryLevel1Name = categoryLevel1Name;
        this.categoryLevel2Name = categoryLevel2Name;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_count='" + admin_count + '\'' +
                ", admin_pass='" + admin_pass + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", admin_level=" + admin_level +
                ", admin_card='" + admin_card + '\'' +
                ", admin_login=" + admin_login +
                ", admin_out=" + admin_out +
                ", admin_photo='" + admin_photo + '\'' +
                ", admin_id=" + admin_id +
                ", categoryLevel1=" + categoryLevel1 +
                ", categoryLevel2=" + categoryLevel2 +
                ", categoryLevel1Name='" + categoryLevel1Name + '\'' +
                ", categoryLevel2Name='" + categoryLevel2Name + '\'' +
                '}';
    }

    public String getAdmin_count() {
        return admin_count;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public void setAdmin_count(String admin_count) {
        this.admin_count = admin_count;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public Integer getAdmin_level() {
        return admin_level;
    }

    public void setAdmin_level(Integer admin_level) {
        this.admin_level = admin_level;
    }

    public String getAdmin_card() {
        return admin_card;
    }

    public void setAdmin_card(String admin_card) {
        this.admin_card = admin_card;
    }

    public Date getAdmin_login() {
        return admin_login;
    }

    public void setAdmin_login(Date admin_login) {
        this.admin_login = admin_login;
    }

    public Date getAdmin_out() {
        return admin_out;
    }

    public void setAdmin_out(Date admin_out) {
        this.admin_out = admin_out;
    }

    public String getAdmin_photo() {
        return admin_photo;
    }

    public void setAdmin_photo(String admin_photo) {
        this.admin_photo = admin_photo;
    }

    public Integer getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(Integer categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public Integer getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(Integer categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public String getCategoryLevel1Name() {
        return categoryLevel1Name;
    }

    public void setCategoryLevel1Name(String categoryLevel1Name) {
        this.categoryLevel1Name = categoryLevel1Name;
    }

    public String getCategoryLevel2Name() {
        return categoryLevel2Name;
    }

    public void setCategoryLevel2Name(String categoryLevel2Name) {
        this.categoryLevel2Name = categoryLevel2Name;
    }
}
