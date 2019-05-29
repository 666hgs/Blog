package main.java.cn.service.dev;



import main.java.cn.pojo.*;

import java.util.List;

public interface LfService {

   Users findLogin(String user_tel, String user_pass);
   List<Users> findUserlist();
   List<Dynamic> findDynamiclist();
   int findlike(String user_tel, Integer dynamic_id);
   int edlike(String user_tel, Integer dynamic_id);
   List<Praise> findPraiselist(String user_tel, Integer dynamic_id);
   Integer finddeletePraise(String user_tel, Integer dynamic_id);
   Integer findCount(Integer dynamic_id);
   int findFollow(String user_tel, String user_tid);
   int edFollow(String user_tel, String user_tid);
   List<Follow> findFollowlist(String user_tel, String user_tid);
   int finddeleteFollow(String user_tel, String user_tid);
   Users findInfo(String user_tel);
   List<Users> findBefwlist(String user_tel);
   int findLong(String user_tel);
   int findFensi(String user_tel);
   int finddeleteFollow2(String user_tel, String user_tid);
   List<Users> findFslist(String user_tel);
   int findbecomeFollow(String user_tel, String fans_tel);
   int upFindInfo(Users users);
   int puFindInfo(Users users);
   List<Dynamic> findmyList(String user_tel);
   Integer findDycount(String user_tel);
   List<Dynamic> findprList(String user_tel);

   /**
    * 用户注册
    * @param user_tel
    * @param user_pass
    * @param user_name
    * @return
    */
   int insertUser( String user_tel,
                  String user_pass,
                   String user_name);


   /**
    * 判断y账号/手机号是否存在
    * @param user_tel
    * @return
    */
   Users exist(String user_tel);

   /**
    * 修改密码
    *
    * @param user_tel
    * @param user_pass
    * @return
    */
   boolean updatepass(String user_tel, String user_pass);

   /**
    * 上传照片
    * @param user_tel
    * @param user_photo
    * @return
    */
   Boolean uphoto(String user_tel,String user_photo);

   /**
    * 删除动态下的所有赞
    * @param dt_id
    * @return
    */
   boolean deletePra(Integer dt_id);
}
