package main.java.cn.service.dev;

import main.java.cn.pojo.Dynamic;

public interface UpLoadService {

    /**
     * 发表动态
     *
     * @param dynamic
     * @return
     */
    boolean upload(Dynamic dynamic);


    /**
     * 删除动态
     * @param dynamic_id
     * @return
     */
    boolean deleteDy(Integer dynamic_id);

}
