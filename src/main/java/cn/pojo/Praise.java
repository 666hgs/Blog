package main.java.cn.pojo;

import java.util.Date;

public class Praise {
    private  Integer like_id;
    private  String  user_id;
    private  Integer dt_id;
    private  Date like_time;
    private  Integer status;


    public Praise() {
    }

    public Praise(Integer like_id, String user_id, Integer dt_id, Date like_time, Integer status) {
        this.like_id = like_id;
        this.user_id = user_id;
        this.dt_id = dt_id;
        this.like_time = like_time;
        this.status = status;
    }

    public Integer getLike_id() {
        return like_id;
    }

    public void setLike_id(Integer like_id) {
        this.like_id = like_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getDt_id() {
        return dt_id;
    }

    public void setDt_id(Integer dt_id) {
        this.dt_id = dt_id;
    }

    public Date getLike_time() {
        return like_time;
    }

    public void setLike_time(Date like_time) {
        this.like_time = like_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Praise{" +
                "like_id=" + like_id +
                ", user_id='" + user_id + '\'' +
                ", dt_id=" + dt_id +
                ", like_time=" + like_time +
                ", status=" + status +
                '}';
    }
}

