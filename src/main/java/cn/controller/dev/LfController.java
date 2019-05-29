package main.java.cn.controller.dev;


import com.alibaba.fastjson.JSONObject;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import main.java.cn.controller.util.AliDayunSms;
import main.java.cn.controller.util.UtilController;
import main.java.cn.pojo.*;
import main.java.cn.service.dev.CommentService;
import main.java.cn.service.dev.LfService;
import main.java.cn.service.util.PlaceService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.io.File;
import java.text.ParseException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static javax.json.bind.JsonbConfig.DATE_FORMAT;


@Controller
@RequestMapping(value = "/Lf")
public class LfController {

    @Resource
    private LfService lfService;
    @Resource
    private CommentService commentService;
    @Resource
    private PlaceService placeService;

    //跳转登录页面
    @RequestMapping(value = "/login")
    public String tologin(HttpSession session,HttpServletRequest request) {
        session.invalidate();
        List<Question> questionList=placeService.question();
        request.setAttribute("questionList",questionList);
        return "dev/login";
    }

    //登录成功后页面
    @RequestMapping(value = "/dologin")
    public String dologin(@RequestParam(value = "user_tel") String user_tel,
                          @RequestParam(value = "user_pass") String user_pass,
                          Model model, HttpSession session) {
        Users users = lfService.findLogin(user_tel, user_pass);
        List<Dynamic> dtlist = lfService.findDynamiclist();
        model.addAttribute("dtlist", dtlist);
        session.setAttribute("users", users);
        int c = lfService.findLong(user_tel);
        int d = lfService.findFensi(user_tel);
        int sz = lfService.findDycount(user_tel);
        users.setDynamic_count(sz);
        users.setFollow_count(c);
        users.setFans_count(d);

        for (Dynamic dlist : dtlist) {
            int a = dlist.getDynamic_id();
            int b = lfService.findCount(a);
            dlist.setLike_count(b);
            Integer dynamic_id = dlist.getDynamic_id();
            String user_tid = dlist.getUser_tid();
            List<Praise> praiseList = lfService.findPraiselist(user_tel, dynamic_id);
            List<Follow> followlist = lfService.findFollowlist(user_tel, user_tid);
            //获取评论总条数
            int num=commentService.getCommentNum(dynamic_id);
            int sizes = praiseList.size();
            int bigs = followlist.size();
            dlist.setSize(sizes);
            dlist.setBig(bigs);
            dlist.setComsun(num);

        }

        return "dev/index";

    }




    //未登录时显示好友动态
    @RequestMapping(value = "/omg")
    public String getDtlist(Model model, HttpSession session) {
        List<Users> userlist = lfService.findUserlist();
        List<Dynamic> dtlist = lfService.findDynamiclist();
        for (Dynamic dlist : dtlist) {
            int a = dlist.getDynamic_id();
            int b = lfService.findCount(a);
            dlist.setLike_count(b);
        }
        model.addAttribute("dtlist", dtlist);
        model.addAttribute("userlist", userlist);
        session.setAttribute("dtlist", dtlist);
        session.setAttribute("userlist", userlist);
        return "dev/index";

    }


    //跳转个人主页
    @RequestMapping(value = "/touser")
    public String touser(Model model, HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        String user_tel = users.getUser_tel();
        Users user=lfService.findInfo(user_tel);
        List<Dynamic> mylist = lfService.findmyList(user_tel);
        int sz = lfService.findDycount(user_tel);
        user.setDynamic_count(sz);
        for (Dynamic list : mylist) {
            int dynamic_id = list.getDynamic_id();
            int count = lfService.findCount(dynamic_id);
            //获取评论总条数
            int num=commentService.getCommentNum(dynamic_id);
            list.setLike_count(count);
            list.setComsun(num);
            List<Praise> praiseList = lfService.findPraiselist(user_tel, dynamic_id);
            int sizes = praiseList.size();
            list.setSize(sizes);
        }
        if (user != null) {
            int a = lfService.findLong(user_tel);
            int b = lfService.findFensi(user_tel);
            user.setFollow_count(a);
            user.setFans_count(b);
            model.addAttribute("user", user);
            model.addAttribute("mylist", mylist);
            model.addAttribute("prlist", "prlist");
        }
        return "dev/user";
    }

    //跳转到用户主页
    @RequestMapping(value = "/userindex")
    public String userindex(@RequestParam(value = "user_tid") String user_tid,
                            HttpServletRequest request){
        Users user=lfService.findInfo(user_tid);
        List<Dynamic> mylist = lfService.findmyList(user_tid);

        //关注，粉丝，动态数
        int sz = lfService.findDycount(user_tid);
        int a = lfService.findLong(user_tid);
        int b = lfService.findFensi(user_tid);
        user.setDynamic_count(sz);
        user.setFollow_count(a);
        user.setFans_count(b);

        for (Dynamic list : mylist) {
            int dynamic_id = list.getDynamic_id();
            //点赞数
            int count = lfService.findCount(dynamic_id);
            list.setLike_count(count);

            //获取评论总条数
            int num=commentService.getCommentNum(dynamic_id);
            list.setComsun(num);

            List<Praise> praiseList = lfService.findPraiselist(user_tid, dynamic_id);
            int sizes = praiseList.size();
            list.setSize(sizes);
        }
        request.setAttribute("user",user);
        request.setAttribute("mylist",mylist);

        return "dev/user";
    }




    //我点过赞的动态
    @ResponseBody
    @RequestMapping(value = "/wdz")
    public Map<String, Object> wdz(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("users");
        String user_tel = user.getUser_tel();
        Map<String, Object> map = new HashMap<>();
        List<Dynamic> pglist = lfService.findprList(user_tel);
        for (Dynamic pr : pglist) {
            int dynamic_id = pr.getDynamic_id();
            int cot = lfService.findCount(dynamic_id);
            pr.setLike_count(cot);
            List<Praise> praiseList = lfService.findPraiselist(user_tel, dynamic_id);
            int ssbb = praiseList.size();
            pr.setSize(ssbb);
        }
        map.put("result", pglist);
        return map;
    }

    // 个人主页获取我的关注列表
    @ResponseBody
    @RequestMapping(value = "/getfollow")
    public Map<String, Object> getfwlist(Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Users user = (Users) session.getAttribute("users");
        String user_tel = user.getUser_tel();
        List<Users> befwlist = lfService.findBefwlist(user_tel);
        if (befwlist.size() > 0) {
            model.addAttribute("befwlist", befwlist);
            map.put("result", befwlist);
        }
        return map;
    }

    //在我的关注里取消关注
    @ResponseBody
    @RequestMapping(value = "/qg")
    public Map<String, Object> defollow(String user_tid,
                                        HttpSession session) {
        Users user = (Users) session.getAttribute("users");
        String user_tel = user.getUser_tel();
        Map<String, Object> map = new HashMap<>();
        lfService.finddeleteFollow2(user_tel, user_tid);
        map.put("result", "success");
        return map;
    }

    //个人主页获取我的粉丝列表
    @ResponseBody
    @RequestMapping(value = "/getfs")
    public Map<String, Object> getfans(Model model, HttpSession session) {
        Users user = (Users) session.getAttribute("users");
        String user_tel = user.getUser_tel();
        Map<String, Object> map = new HashMap<>();
        List<Users> fanslist = lfService.findFslist(user_tel);
        /*LinkedList<Integer> listLength=new LinkedList<>();*/
        if (fanslist.size() > 0) {
            for (Users auto : fanslist) {
                String a = auto.getUser_tel();
                List<Follow> followlist = lfService.findFollowlist(user_tel, a);
                /* listLength.add(followlist.size());*/
                int lengs = followlist.size();
                auto.setLeng(lengs);
            }
            map.put("result", fanslist);
            /*map.put("listLeng",listLength);*/
        }
        return map;
    }


    //在粉丝列表关注我的粉丝
    @ResponseBody
    @RequestMapping(value = "/py")
    public Map<String, Object> py(@RequestParam(value = "fans_tel") String fans_tel,
                                  Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Users user = (Users) session.getAttribute("users");
        String user_tel = user.getUser_tel();
        int p = lfService.findbecomeFollow(user_tel, fans_tel);
        if (p > 0) {
            map.put("result", "success");
        } else {
            map.put("result", "error");
        }
        return map;
    }


    // 点赞与取消点赞
    @ResponseBody
    @RequestMapping(value = "/rng")
    public Map<String, Object> dolike(@RequestParam(value = "dynamic_id") Integer dynamic_id,
                                      Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Users user = (Users) session.getAttribute("users");
        String user_tel = user.getUser_tel();
        List<Praise> praiseList = lfService.findPraiselist(user_tel, dynamic_id);
        int sizes = praiseList.size();
        if (praiseList.size() > 0) {
            lfService.finddeletePraise(user_tel, dynamic_id);
            map.put("result", "delete");
        } else {
            int p = lfService.findlike(user_tel, dynamic_id);
            int q = lfService.edlike(user_tel, dynamic_id);
            if (p > 0 && q > 0) {
                map.put("result", "success");
            } else {
                map.put("result", "error");
            }
        }
        return map;
    }


    //关注与取消关注
    @ResponseBody
    @RequestMapping(value = "/skt")
    public Map<String, Object> dofollow(@RequestParam(value = "user_tid") String user_tid,
                                        Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Users user=(Users)session.getAttribute("users");
        String user_tel=user.getUser_tel();
        List<Follow> followList = lfService.findFollowlist(user_tel, user_tid);
        int sizes = followList.size();
        if (sizes > 0) {
            lfService.finddeleteFollow(user_tel, user_tid);
            map.put("result", "qg");


        } else {
            int p = lfService.findFollow(user_tel, user_tid);
            int q = lfService.edFollow(user_tel, user_tid);

            if (p > 0 && q > 0) {
                map.put("result", "chenggong");

            } else {
                map.put("result", "error");
            }
        }

        return map;
    }


    //个人主页修改信息
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String upInfo(Model model, Users newuser) {
        int a = lfService.upFindInfo(newuser);

        return "redirect:touser";
    }

    //个人主页修改信息
    @RequestMapping(value = "/pudate", method = RequestMethod.POST)
    public String puInfo(@RequestParam(value = "user_email") String user_email,
                         @RequestParam(value = "user_qq") String user_qq,
                         HttpSession session) {
        String a = String.valueOf(user_email);
        String b = String.valueOf(user_qq);
        Users xuser = (Users) session.getAttribute("users");
        xuser.setUser_email(a);
        xuser.setUser_qq(b);
        int c = lfService.puFindInfo(xuser);
        return "redirect:touser";
    }


    @ResponseBody
    @RequestMapping(value = "/exit.json")
    public Object exit(@RequestParam(value = "user_tel") String user_tel){
        Map<String,Object> map=new HashMap();
        Users users= lfService.exist(user_tel);
        if (users!=null){
            map.put("msg","exit");
            map.put("msg","exit");
        }else {
            map.put("msg","noexit");
        }
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/doregister")
    public String doregister(@RequestParam(value = "user_tel") String user_tel,
                             @RequestParam(value = "user_pass") String user_pass,
                             @RequestParam(value = "user_name") String user_name,
                             @RequestParam(value = "questionid") Integer questionid,
                             @RequestParam(value = "question") String question){
        lfService.insertUser(user_tel,user_pass,user_name);
        Secret secret=new Secret(user_tel,questionid,question);

        placeService.addquestion(secret);
        return "redirect:login";
    }

    @RequestMapping(value = "usermessage")
    public String usermessage(){
        return "dev/usermessage";
    }

    @RequestMapping(value = "/logout.html")
    public String logout(HttpSession session){
        session.invalidate();
        return "dev/login";
    }

    @RequestMapping(value = "/checktel.html")
    public String checktel(){
        return "dev/tel_check";
    }

    /**
     * 判断成功后把usertel放session
     * @param user_tel
     * @param session
     * @return
     */
    @RequestMapping(value = "/tel_way")
    public String tel_way(@RequestParam(value = "user_tel") String user_tel,
                          HttpSession session){
        Map<String,Object> map=new HashMap<>();
        map.put("user_tel",user_tel);
        map.put("show_tel",user_tel.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        session.setAttribute("map",map);
        return "redirect:/Lf/tel_way.html";
    }

    /**
     * 发送短信
     * @param session
     * @return
     * @throws ClientException
     */
    @RequestMapping(value = "/code.json")
    @ResponseBody
    public Object smscod(HttpSession session) throws ClientException {
        AliDayunSms aliDayunSms = new AliDayunSms();
        //随机生成验证码
        aliDayunSms.setNewcode();
        String code = Integer.toString(aliDayunSms.getNewcode());

        //获得user_tel
        Map<String,Object> map=(Map)session.getAttribute("map");
        String user_tel=(String)map.get("user_tel");

        //发送验证码
        SendSmsResponse sendSms=aliDayunSms.sendSms(user_tel,code);
        return JSONObject.toJSON(code);
    }

    /**
     * 找回密码更新密码
     * @param user_pass
     * @param session
     * @return
     */
    @RequestMapping(value = "/changepass")
    public String changepass(@RequestParam(value = "user_pass") String user_pass,
                             HttpSession session){
        Map<String,Object> map=(Map)session.getAttribute("map");
        String user_tel=(String)map.get("user_tel");
        lfService.updatepass(user_tel,user_pass);
        session.invalidate();
        return "redirect:/Lf/login";
    }

    @RequestMapping(value = "/tel_secret.html")
    public String tel_secret(HttpSession session,
                             HttpServletRequest request){
        Map<String,Object> map=(Map)session.getAttribute("map");
        String user_tel=(String)map.get("user_tel");
        Secret secret=placeService.getqa(user_tel);
        request.setAttribute("secret",secret);
        return "dev/tel_secret";
    }

    @RequestMapping(value = "photo")
    public String adminadd(@RequestParam(value = "user_tel") String user_tel,
                           @RequestParam(value ="a_userPhoto", required = false) MultipartFile multipartFile,
                           HttpSession session,
                           HttpServletRequest request){

        String user_photo=null;
        ///上传文件
        if (!multipartFile.isEmpty()){//判断是否有上传文件
            //上传到什么地方
            String realPath = session.getServletContext().getRealPath("/statics/images/");
            System.out.println(realPath);
            //获得文件后缀
            String originalFilename = multipartFile.getOriginalFilename();
            String suffix = FilenameUtils.getExtension(originalFilename);
            if(multipartFile.getSize() >  500000){//上传大小不得超过 500k
                request.setAttribute("uploadFileError", " * 上传大小不得超过 500k");
                return "redirect:touser";
            }else if(suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png")
                    || suffix.equalsIgnoreCase("jpeg") || suffix.equalsIgnoreCase("pneg")) {//上传图片格式不正确

                String fileName = System.currentTimeMillis() + new Random().nextInt(1000000) + "_Personal.jpg";

                File targetFile = new File(realPath, fileName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                //保存
                try {
                    multipartFile.transferTo(targetFile);
                } catch (Exception s) {
                    s.printStackTrace();
                    request.setAttribute("uploadFileError", " * 上传失败！");
                    return "redirect:touser";
                }
                user_photo="/statics/images/"+fileName;
            }
        }
        lfService.uphoto(user_tel,user_photo);
        commentService.upuserphoto(user_tel,user_photo);
        return "redirect:touser";
    }

    @RequestMapping(value = "/tel_way.html")
    public String tel_wayhtml(){
        return "dev/tel_ways";
    }
    @RequestMapping(value = "/tel_code.html")
    public String tel_code(){
        return "dev/tel_code";
    }
    @RequestMapping(value = "/tel_changepass.html")
    public String tel_changepass(){
        return "dev/tel_changepass";
    }
}
