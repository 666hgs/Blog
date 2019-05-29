package main.java.cn.service.dev.impl;

import main.java.cn.dao.dev.UpLoadMapper;
import main.java.cn.pojo.Dynamic;
import main.java.cn.service.dev.UpLoadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UpLoadServiceImpl implements UpLoadService {

    @Resource
    private UpLoadMapper upLoadMapper;

    @Override
    public boolean upload(Dynamic dynamic) {
        return upLoadMapper.upload(dynamic);
    }

    @Override
    public boolean deleteDy(Integer dynamic_id) {
        return upLoadMapper.deleteDy(dynamic_id);
    }
}
