package main.java.cn.service.backend;

import main.java.cn.pojo.Admin;
import main.java.cn.pojo.Place;

import java.util.List;


public interface AdminService {

    /**
     * 管理员登录
     *
     * @param admin_count
     * @param admin_pass
     * @return
     */
    Admin login(String admin_count, String admin_pass);

    /**
     * 管理员修改密码
     *
     * @param admin_pass
     * @param admin_count
     * @return
     */
    boolean updatepass(String admin_pass, String admin_count);

    /**
     * 返回管理员集合
     *
     * @return
     */
    List<Admin> adminlist();

    /**
     * 管理员账号删除
     *
     * @param admin_count
     * @return
     */
    boolean deleteadmin(String admin_count);

    /**
     * 添加新管理员信息
     *
     * @param admin_count
     * @param admin_name
     * @param admin_card
     * @param admin_photo
     * @param categoryLevel1
     * @param categoryLevel2
     * @return
     */
    boolean addadmin(String admin_count, String admin_name, String admin_card, String admin_photo,Integer categoryLevel1,Integer categoryLevel2);

    /**
     * 返回管理员信息
     *
     * @param admin_id
     * @return
     */
    Admin adminmessage(String admin_id);

    /**
     * 返回地址集合
     *
     * @param parentid
     * @return
     */
    List<Place> placelist(Integer parentid);

    /**
     * 管理员信息更新
     *
     * @param admin_name
     * @param admin_card
     * @param admin_photo
     * @param categoryLevel1
     * @param categoryLevel2
     * @param admin_id
     * @return
     */
    boolean upmessage(String admin_name,String admin_card,String admin_photo,Integer categoryLevel1,Integer categoryLevel2,Integer admin_id);

    /**
     * 判断管理员账号是否存在
     * @param admin_count
     * @return
     */
    Admin aexist(String admin_count);

    /**
     * 统计管理员数量
     * @return
     */
    Integer countadmin();

    /**
     * 统计用户数量
     * @return
     */
    Integer countuser();
}
