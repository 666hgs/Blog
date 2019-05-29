package main.java.cn.pojo;


import java.sql.Timestamp;

public class Soncomment {

  private String myname;
  private String othername;
  private String reply;
  private Timestamp time;
  private int commentId;
  private String timeChange;

  public String getTimeChange() {
    return timeChange;
  }

  public void setTimeChange(String timeChange) {
    this.timeChange = timeChange;
  }

  public String getMyname() {
    return myname;
  }

  public void setMyname(String myname) {
    this.myname = myname;
  }

  public String getOthername() {
    return othername;
  }

  public void setOthername(String othername) {
    this.othername = othername;
  }

  public String getReply() {
    return reply;
  }

  public void setReply(String reply) {
    this.reply = reply;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public int getCommentId() {
    return commentId;
  }

  public void setCommentId(int commentId) {
    this.commentId = commentId;
  }

  public Soncomment() {
  }

  public Soncomment(String myname, String othername, String reply, Timestamp time, int commentId) {
    this.myname = myname;
    this.othername = othername;
    this.reply = reply;
    this.time = time;
    this.commentId = commentId;
  }
}
