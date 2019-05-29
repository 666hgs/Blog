package main.java.cn.service.dev.impl;

import main.java.cn.dao.dev.CommentMapper;
import main.java.cn.pojo.Comment;
import main.java.cn.pojo.Dynamic;
import main.java.cn.pojo.Soncomment;
import main.java.cn.service.dev.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
  @Resource
  private CommentMapper commentMapper;

  @Override
  public List<Comment> getCommentList(int dynamic_Id) {
    return commentMapper.getCommentList(dynamic_Id);
  }

  @Override
  public boolean addComment(Comment comment) {
    return commentMapper.addComment(comment);
  }

  @Override
  public List<Soncomment> getSonCommentList() {
    return commentMapper.getSonCommentList();
  }

  @Override
  public boolean addSonComment(Soncomment soncomment) {
    return commentMapper.addSonComment(soncomment);
  }

  @Override
  public int getCommentNum(int dynamic_Id) {
    return commentMapper.getCommentNum(dynamic_Id);
  }

  @Override
  public Dynamic getDynamic(int dynamic_id) {
    return commentMapper.getDynamic(dynamic_id);
  }

  @Override
  public boolean upuserphoto(String user_tid, String user_photo) {
    return commentMapper.upuserphoto(user_tid,user_photo);
  }

  @Override
  public boolean deltetCom(Integer dynamic_id) {
    return commentMapper.deltetCom(dynamic_id);
  }

}



