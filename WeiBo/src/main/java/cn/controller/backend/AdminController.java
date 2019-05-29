package main.java.cn.controller.backend;

import com.alibaba.fastjson.JSONObject;
import main.java.cn.pojo.Admin;
import main.java.cn.pojo.Place;
import main.java.cn.service.backend.AdminService;
import main.java.cn.service.util.PlaceService;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping(value = "/backend")
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private PlaceService placeService;

    /**
     * 管理员登录
     * @param admin_count
     * @param admin_pass
     * @param session
     * @return
     */
    @RequestMapping("/dologin")
    public String dologin(@Param("admin_count")String admin_count,
                          @Param("admin_pass")String admin_pass,
                          HttpSession session){
        Admin admin=adminService.login(admin_count,admin_pass);
        session.setAttribute("admin",admin);
        if (admin!=null){
            return "redirect:/backend/backindex.html";
        }
        return "backend/backendlogin";
    }

    /**
     * 管理员注销
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout.html")
    public String logout(HttpSession session){
        session.invalidate();
        return "backend/backendlogin";
    }

    /**
     * 旧密码确认
     * @param old
     * @param session
     * @return
     */
    @RequestMapping(value = "/oldpass.json")
    @ResponseBody
    public Object oldpass(@RequestParam(value = "old") String old,
                          HttpSession session){
        Map<String,Object> map=new HashMap();
        Admin admin =(Admin)session.getAttribute("admin");
        if (old.equals(admin.getAdmin_pass())){
            map.put("msg","success");
        }else {
            map.put("msg","error");
        }
        return JSONObject.toJSON(map);
    }

    /**
     * 修改密码
     * @param newpass
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/changpass")
    public String changpass(@RequestParam(value = "newpass") String newpass,
                            HttpSession session,
                            HttpServletRequest request){
        Admin admin=(Admin)session.getAttribute("admin");
        adminService.updatepass(newpass,admin.getAdmin_count());
        session.invalidate();
        request.setAttribute("msg","密码修改成功，请重新登录！");
        return "backend/backendlogin";
    }

    /**
     * 删除管理员
     * @param admin_count
     * @return
     */
    @RequestMapping(value = "deleteadmin")
    public String deleteadmin(@RequestParam(value = "admin_count") String admin_count){
        adminService.deleteadmin(admin_count);
        return "redirect:/backend/adminlist.html";
    }

    /**
     * 添加管理员信息
     * @param admin_count
     * @param admin_name
     * @param admin_card
     * @param multipartFile
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = " adminadd")
    public String adminadd(@RequestParam(value = "admin_count") String admin_count,
                           @RequestParam(value = "admin_name") String admin_name,
                           @RequestParam(value = "admin_card") String admin_card,
                           @RequestParam(value = "categoryLevel1") Integer categoryLevel1,
                           @RequestParam(value = "categoryLevel2") Integer categoryLevel2,
                           @RequestParam(value ="a_userPhoto", required = false) MultipartFile multipartFile,
                           HttpSession session,
                           HttpServletRequest request){

        String admin_photo=null;
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
                return "redirect:/backend/adminlist.html";
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
                    return "redirect:/backend/adminlist.html";
                }
                admin_photo="/statics/images/"+fileName;
            }
        }
        adminService.addadmin(admin_count,admin_name,admin_card,admin_photo,categoryLevel1,categoryLevel2);

        return "redirect:/backend/adminlist.html";
    }

    /**
     * 管理员修改个人信息
     * @param admin_name
     * @param admin_card
     * @param categoryLevel1
     * @param categoryLevel2
     * @param admin_id
     * @param multipartFile
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "upmessage")
    public String upmessage(@RequestParam(value = "admin_name") String admin_name,
                           @RequestParam(value = "admin_card") String admin_card,
                           @RequestParam(value = "categoryLevel1") Integer categoryLevel1,
                           @RequestParam(value = "categoryLevel2") Integer categoryLevel2,
                            @RequestParam(value = "admin_id") Integer admin_id,
                           @RequestParam(value ="a_userPhoto", required = false) MultipartFile multipartFile,
                           HttpSession session,
                           HttpServletRequest request){

        String admin_photo=null;
        if (!multipartFile.isEmpty()){
            String realPath = session.getServletContext().getRealPath("/statics/images/");
            System.out.println(realPath);
            String originalFilename = multipartFile.getOriginalFilename();
            String suffix = FilenameUtils.getExtension(originalFilename);
            if(multipartFile.getSize() >  500000){
                request.setAttribute("uploadFileError", " * 上传大小不得超过 500k");
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
                }
                admin_photo="/statics/images/"+fileName;
            }
        }
        adminService.upmessage(admin_name,admin_card,admin_photo,categoryLevel1,categoryLevel2,admin_id);

        return "redirect:/backend/adminlist.html";
    }




    /**
     * 地址根据一级加载二级
     * @param id
     * @return
     */
    @RequestMapping(value = "categoryLevelList.json")
    @ResponseBody
    public Object categoryLevelList(@RequestParam(value = "id") Integer id){
        List<Place> list2= adminService.placelist(id);
        return JSONObject.toJSON(list2);
    }

    /**
     * 后台管理员列表信息页面跳转
     * @return
     */
    @RequestMapping(value = "/adminlist.html")
    public String adminlisthtml(Model model){
        List<Admin> adminlist=adminService.adminlist();
        List<Place> placelist=placeService.placelist(0);
        model.addAttribute("adminlist",adminlist);
        model.addAttribute("placelist",placelist);
        return "backend/adminlist";
    }
    /**
     * 后台登录界面跳转
     * @return
     */
    @RequestMapping("/baccklogin.html")
    public String backlogin(){return "backend/backendlogin";}

    /**
     * 后台主页跳转
     * @return
     */
    @RequestMapping("/backindex.html")
    public String backindex(HttpServletRequest request){
        int admincount=adminService.countadmin();
        int usercount=adminService.countuser();
        request.setAttribute("admincount",admincount);
        request.setAttribute("usercount",usercount);
        return "backend/main";
    }

    /**
     * 修改密码页面跳转
     * @return
     */
    @RequestMapping("/ChangePassword.html")
    public String ChangePassword(){
        return "backend/ChangePassword";
    }

    @RequestMapping("/adminmessage.html")
    public String adminmessage(@RequestParam(value = "admin_id") String admin_id,
                               Model model){
        Admin admin=adminService.adminmessage(admin_id);

        List<Place> categoryLevel1list=adminService.placelist(0);
        List<Place> categoryLevel2list=adminService.placelist(admin.getCategoryLevel1());
        model.addAttribute("admin",admin);
        model.addAttribute("categoryLevel1list",categoryLevel1list);
        model.addAttribute("categoryLevel2list",categoryLevel2list);
        return "backend/adminmessage";
    }

    @RequestMapping("/aexit.json")
    @ResponseBody
    public Object aexit(@RequestParam(value = "admin_count") String admin_count){
        Map<String,Object> map=new HashMap();
        Admin admin= adminService.aexist(admin_count);
        if(admin!=null){
            map.put("msg","exit");
        }else {
            map.put("msg","noexit");
        }
        return JSONObject.toJSON(map);
    }

}
