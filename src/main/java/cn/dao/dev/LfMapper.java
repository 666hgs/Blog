package main.java.cn.dao.dev;

import main.java.cn.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LfMapper {

    Users getLogin(@Param("user_tel") String user_tel, @Param("user_pass") String user_pass);
    List<Users> getUserlist();
    List<Dynamic>getDynamiclist();
    int getLike(@Param("user_tel") String user_tel,
                @Param("dynamic_id") Integer dynamic_id);
    int delike(@Param("user_tel") String user_tel,
               @Param("dynamic_id") Integer dynamic_id);
    List<Praise> getPraiselist(@Param("user_tel") String user_tel,
                               @Param("dynamic_id") Integer dynamic_id);   //查找用户是否对一篇文章点过赞

    Integer deletePraise(@Param("user_tel") String user_tel,
                         @Param("dynamic_id") Integer dynamic_id);   //取消赞

    Integer getCount(Integer dynamic_id);  //得到一篇文章的点赞总次数

    int getFollow(@Param("user_tel") String user_tel,
                  @Param("user_tid") String user_tid);
    int deFollow(@Param("user_tel") String user_tel,
                 @Param("user_tid") String user_tid);

    List<Follow>getFollowlist(@Param("user_tel") String user_tel,
                              @Param("user_tid") String user_tid);   //查找用户是否关注过某个用户
    Integer deleteFollow(@Param("user_tel") String user_tel,
                         @Param("user_tid") String user_tid);   //取消关注
    Users getInfo(String user_tel);     //获取个人主页信息
    List<Users> getUlist(String user_tel);   //获取我的关注列表
    Integer getLong(String user_tel);    //获取用户的关注总数
    Integer getFensi(String user_tel);     //获取用户的粉丝总数
    Integer deleteFollow2(@Param("user_tel") String user_tel,
                          @Param("user_tid") String user_tid);   //在我的关注列表里执行取消关注
    List<Users>getFslist(String user_tel); //获取我的粉丝列表
    int  becomeFollow(@Param("user_tel") String user_tel,
                      @Param("fans_tel") String fans_tel); //在我的粉丝列表里执行关注操作
     int upInfo(Users users);   //个人主页修改信息
     int puInfo(Users users);   //个人主页修改信息
     List<Dynamic> getmyList(String user_tel);                           //个人主页获取我的动态
     Integer getDycount(String user_tel);      //个人主页获取我的关注总数
     List<Dynamic> getprList(String user_tel);  //个人主页获取我点过赞的动态

    /**
     * 用户注册
     * @param user_tel
     * @param user_pass
     * @param user_name
     * @return
     */
    int insertUser(@Param("user_tel") String user_tel,
                   @Param("user_pass") String user_pass,
                   @Param("user_name") String user_name);

    /**
     * 判断y账号/手机号是否存在
     * @param user_tel
     * @return
     */
    Users exist(@Param("user_tel") String user_tel);

    /**
     * 修改密码
     *
     * @param user_tel
     * @param user_pass
     * @return
     */
    boolean updatepass(@Param("user_tel") String user_tel,
                       @Param("user_pass") String user_pass);


    /**
     * 上传照片
     * @param user_tel
     * @param user_photo
     * @return
     */
    Boolean uphoto(@Param("user_tel") String user_tel,@Param("user_photo") String user_photo);


    /**
     * 删除动态下的所有赞
     * @param dt_id
     * @return
     */
    boolean deletePra(@Param("dt_id") Integer dt_id);



}
