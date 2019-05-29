package main.java.cn.dao.dev;

import main.java.cn.pojo.Comment;
import main.java.cn.pojo.Dynamic;
import main.java.cn.pojo.Soncomment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    List<Comment> getCommentList(@Param(value = "dynamic_Id") int dynamic_Id);
    boolean addComment(Comment comment);
    List<Soncomment> getSonCommentList();
    boolean addSonComment(Soncomment soncomment);
    int getCommentNum(@Param(value = "dynamic_Id") int dynamic_Id);

    /**
     * 根据动态id返回动态信息
     * @param dynamic_id
     * @return
     */
    Dynamic getDynamic(@Param(value = "dynamic_id")int dynamic_id);

    /**
     * 跟新动态用户照片
     * @param user_tid
     * @param user_photo
     * @return
     */
    boolean upuserphoto(@Param(value = "user_tid")String user_tid,
                        @Param(value = "user_photo")String user_photo);


    /**
     * 删除动态下的所有评论
     * @param dynamic_id
     * @return
     */
    boolean deltetCom(@Param(value = "dynamic_id")Integer dynamic_id);
}
