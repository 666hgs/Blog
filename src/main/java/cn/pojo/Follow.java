package main.java.cn.pojo;

public class Follow {
    private Integer follow_id;
    private  String follower_id;
    private  String befollower_id;
    private  Integer status;

    public Follow() {
    }


    public Follow(Integer follow_id, String follower_id, String befollower_id, Integer status) {
        this.follow_id = follow_id;
        this.follower_id = follower_id;
        this.befollower_id = befollower_id;
        this.status = status;
    }

    public Integer getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(Integer follow_id) {
        this.follow_id = follow_id;
    }

    public String getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(String follower_id) {
        this.follower_id = follower_id;
    }

    public String getBefollower_id() {
        return befollower_id;
    }

    public void setBefollower_id(String befollower_id) {
        this.befollower_id = befollower_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "follow_id=" + follow_id +
                ", follower_id='" + follower_id + '\'' +
                ", befollower_id=" + befollower_id +
                ", status=" + status +
                '}';
    }
}
