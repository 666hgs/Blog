package main.java.cn.service.util.impl;

import main.java.cn.dao.util.PlaceMapper;
import main.java.cn.pojo.Place;
import main.java.cn.pojo.Question;
import main.java.cn.pojo.Secret;
import main.java.cn.service.util.PlaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Resource
    private PlaceMapper placeMapper;

    @Override
    public List<Place> placelist(Integer parentid) {
        return placeMapper.placelist(parentid);
    }

    @Override
    public List<Question> question() {
        return placeMapper.question();
    }

    @Override
    public boolean addquestion(Secret secret) {
        return placeMapper.addquestion(secret);
    }

    @Override
    public Secret getqa(String user_tel) {
        return placeMapper.getqa(user_tel);
    }
}
