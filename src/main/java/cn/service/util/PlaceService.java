package main.java.cn.service.util;

import main.java.cn.pojo.Place;
import main.java.cn.pojo.Question;
import main.java.cn.pojo.Secret;

import java.util.List;

public interface PlaceService {

    /**
     * 返回地址集合
     *
     * @param parentid
     * @return
     */
    List<Place> placelist(Integer parentid);

    /**
     * 密保问题集合
     * @return
     */
    List<Question> question();

    /**
     * 插入用户密保及答案
     * @param secret
     * @return
     */
    boolean addquestion(Secret secret);

    /**
     * 返回用户密保及答案
     * @param user_tel
     * @return
     */
    Secret getqa(String user_tel);
}
