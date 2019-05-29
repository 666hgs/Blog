package main.java.cn.service.dev;

import main.java.cn.pojo.Comment;
import main.java.cn.pojo.Dynamic;
import main.java.cn.pojo.Soncomment;

import java.util.List;

public interface CommentService {
    public List<Comment> getCommentList(int dynamic_Id);
    public boolean addComment(Comment comment);

    public List<Soncomment> getSonCommentList();
    public boolean addSonComment(Soncomment soncomment);

    public int getCommentNum(int dynamic_Id);

    /**
     * 根据动态id返回动态信息
     * @param dynamic_id
     * @return
     */
    Dynamic getDynamic(int dynamic_id);

    /**
     * 跟新动态用户照片
     * @param user_tid
     * @param user_photo
     * @return
     */
    boolean upuserphoto(String user_tid, String user_photo);

    /**
     * 删除动态下的所有评论
     * @param dynamic_id
     * @return
     */
    boolean deltetCom(Integer dynamic_id);
}
