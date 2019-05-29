package main.java.cn.controller.util;

import com.alibaba.fastjson.JSONObject;
import main.java.cn.pojo.Place;
import main.java.cn.service.util.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/util")
public class UtilController {
    @Resource
    private PlaceService placeService;


    /**
     * 地址根据一级加载二级
     * @param id
     * @return
     */
    @RequestMapping(value = "categoryLevelList.json")
    @ResponseBody
    public Object categoryLevelList(@RequestParam(value = "id") Integer id){
        List<Place> list2= placeService.placelist(id);
        return JSONObject.toJSON(list2);
    }


}
