package main.java.cn.dao.dev;

import main.java.cn.pojo.Dynamic;
import org.apache.ibatis.annotations.Param;

public interface UpLoadMapper {

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
    boolean deleteDy(@Param("dynamic_id") Integer dynamic_id);

}
