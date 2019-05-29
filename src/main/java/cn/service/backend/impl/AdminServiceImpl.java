package main.java.cn.service.backend.impl;

import main.java.cn.dao.backend.AdminMapper;
import main.java.cn.pojo.Admin;
import main.java.cn.pojo.Place;
import main.java.cn.service.backend.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(String admin_count, String admin_pass) {
        return adminMapper.login(admin_count,admin_pass);
    }

    @Override
    public boolean updatepass(String admin_pass, String admin_count) {
        return adminMapper.updatepass(admin_pass,admin_count);
    }

    @Override
    public List<Admin> adminlist() {
        return adminMapper.adminlist();
    }

    @Override
    public boolean deleteadmin(String admin_count) {
        return adminMapper.deleteadmin(admin_count);
    }

    @Override
    public boolean addadmin(String admin_count, String admin_name, String admin_card, String admin_photo, Integer categoryLevel1, Integer categoryLevel2) {
        return adminMapper.addadmin(admin_count,admin_name,admin_card,admin_photo,categoryLevel1,categoryLevel2);
    }


    @Override
    public Admin adminmessage(String admin_id) {
        return adminMapper.adminmessage(admin_id);
    }

    @Override
    public List<Place> placelist(Integer parentid) {
        return adminMapper.placelist(parentid);
    }

    @Override
    public boolean upmessage(String admin_name, String admin_card, String admin_photo, Integer categoryLevel1, Integer categoryLevel2, Integer admin_id) {
        return adminMapper.upmessage(admin_name,admin_card,admin_photo,categoryLevel1,categoryLevel2,admin_id);
    }

    @Override
    public Admin aexist(String admin_count) {
        return adminMapper.aexist(admin_count);
    }

    @Override
    public Integer countadmin() {
        return adminMapper.countadmin();
    }

    @Override
    public Integer countuser() {
        return adminMapper.countuser();
    }
}
