package main.java.cn.service.dev.impl;

import main.java.cn.dao.dev.LfMapper;
import main.java.cn.pojo.*;
import main.java.cn.service.dev.LfService;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service("LfService")
public class LfServiceImpl implements LfService {
    @Resource
    LfMapper lfMapper;

    @Override
    public Users findLogin(String user_tel, String user_pass) {
        return lfMapper.getLogin(user_tel,user_pass);
    }

    @Override
    public List<Users> findUserlist() {
        return lfMapper.getUserlist();
    }

    @Override
    public List<Dynamic> findDynamiclist() {

        return lfMapper.getDynamiclist();
    }

    @Override
    public int findlike(String user_tel,Integer dynamic_id) {
        return lfMapper.getLike(user_tel,dynamic_id);

    }

    @Override
    public int edlike(String user_tel, Integer dynamic_id)
    {
        return lfMapper.delike(user_tel, dynamic_id);
    }

    @Override
    public List<Praise> findPraiselist(String user_tel, Integer dynamic_id) {

        return lfMapper.getPraiselist(user_tel,dynamic_id);
    }

    @Override
    public Integer finddeletePraise(String user_tel, Integer dynamic_id) {
        return lfMapper.deletePraise(user_tel,dynamic_id);
    }

    @Override
    public  Integer findCount(Integer dynamic_id) {
        return lfMapper.getCount(dynamic_id);
    }

    @Override
    public int findFollow(String user_tel, String user_tid) {
        return lfMapper.getFollow(user_tel,user_tid);
    }

    @Override
    public int edFollow(String user_tel, String user_tid) {
        return lfMapper.deFollow(user_tel, user_tid);
    }

    @Override
    public List<Follow> findFollowlist(String user_tel, String user_tid) {
        return lfMapper.getFollowlist(user_tel,user_tid);
    }

    @Override
    public int finddeleteFollow(String user_tel, String user_tid) {
        return lfMapper.deleteFollow(user_tel,user_tid);
    }

    @Override
    public Users findInfo(String user_tel) {
        return lfMapper.getInfo(user_tel);
    }

    @Override
    public List<Users> findBefwlist(String user_tel) {
        return lfMapper.getUlist(user_tel);
    }

    @Override
    public int findLong(String user_tel) {
        return lfMapper.getLong(user_tel);
    }

    @Override
    public int findFensi(String user_tel) {
        return lfMapper.getFensi(user_tel);
    }

    @Override
    public int finddeleteFollow2(String user_tel, String user_tid) {
        return lfMapper.deleteFollow2(user_tel,user_tid);
    }

    @Override
    public List<Users> findFslist(String user_tel) {
        return lfMapper.getFslist(user_tel);
    }

    @Override
    public int findbecomeFollow(String user_tel, String fans_tel) {
        return lfMapper.becomeFollow(user_tel,fans_tel);
    }

    @Override
    public int upFindInfo(Users users) {
        return lfMapper.upInfo(users);
    }

    @Override
    public int puFindInfo(Users users) {
        return lfMapper.puInfo(users);
    }

    @Override
    public List<Dynamic> findmyList(String user_tel) {
        return lfMapper.getmyList(user_tel);
    }

    @Override
    public Integer findDycount(String user_tel) {
        return lfMapper.getDycount(user_tel);
    }

    @Override
    public List<Dynamic> findprList(String user_tel) {
        return lfMapper.getprList(user_tel);
    }

    @Override
    public int insertUser(String user_tel, String user_pass, String user_name) {
        return lfMapper.insertUser(user_tel,user_pass,user_name);
    }


    @Override
    public Users exist(String user_tel) {
        return lfMapper.exist(user_tel);
    }

    @Override
    public boolean updatepass(String user_tel, String user_pass) {
        return lfMapper.updatepass(user_tel,user_pass);
    }


    @Override
    public Boolean uphoto(String user_tel, String user_photo) {
        return lfMapper.uphoto(user_tel,user_photo);
    }

    @Override
    public boolean deletePra(Integer dt_id) {
        return lfMapper.deletePra(dt_id);
    }


}
