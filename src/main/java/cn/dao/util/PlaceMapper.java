package main.java.cn.dao.util;

import main.java.cn.pojo.Place;
import main.java.cn.pojo.Question;
import main.java.cn.pojo.Secret;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlaceMapper {

    /**
     * 返回地址集合
     *
     * @param parentid
     * @return
     */
    List<Place> placelist(@Param("parentid")Integer parentid);

    /**
     * 密保问题集合
     * @return
     */
    List<Question> question();

    /**
     * 返回用户密保及答案
     * @param user_tel
     * @return
     */
    Secret getqa(@Param("user_tel")String user_tel);

    /**
     * 插入用户密保及答案
     * @param secret
     * @return
     */
    boolean addquestion(Secret secret);

}
