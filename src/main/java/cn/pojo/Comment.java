package main.java.cn.pojo;



import java.sql.Timestamp;
import java.util.List;

public class Comment {

  private int commentId;
  private String comment;
  private String name;
  private String photo;
  private Timestamp time;
  private int dynamic_Id;
  private String timeChange;
  private List<Soncomment> soncommentList;


  public List<Soncomment> getSoncommentList() {
    return soncommentList;
  }

  public void setSoncommentList(List<Soncomment> soncommentList) {
    this.soncommentList = soncommentList;
  }

  public String getTimeChange() {
    return timeChange;
  }

  public void setTimeChange(String timeChange) {
    this.timeChange = timeChange;
  }

  public int getCommentId() {
    return commentId;
  }

  public void setCommentId(int commentId) {
    this.commentId = commentId;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public int getDynamic_Id() {
    return dynamic_Id;
  }

  public void setDynamic_Id(int dynamic_Id) {
    this.dynamic_Id = dynamic_Id;
  }

  public Comment() {
  }

  public Comment(String comment, String name, String photo, Timestamp time, int dynamic_Id) {
    this.comment = comment;
    this.name = name;
    this.photo = photo;
    this.time = time;
    this.dynamic_Id = dynamic_Id;
  }
}
