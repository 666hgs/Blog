package main.java.cn.controller.dev;

import main.java.cn.pojo.Dynamic;
import main.java.cn.pojo.Users;
import main.java.cn.service.dev.CommentService;
import main.java.cn.service.dev.LfService;
import main.java.cn.service.dev.UpLoadService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Random;

@Controller
@RequestMapping(value = "/up")
public class UpLoadController {

    @Resource
    private UpLoadService upLoadService;
    @Resource
    private CommentService commentService;
    @Resource
    private LfService lfService;

    @RequestMapping(value = "/sendBolg")
    public String sendBolg(@RequestParam(value ="dynamic_text") String dynamic_text,
                           @RequestParam(value ="a_userPhoto", required = false) MultipartFile multipartFile,
                           @RequestParam(value ="a_userPhoto2", required = false) MultipartFile multipartFile2,
                           @RequestParam(value ="a_userPhoto3", required = false) MultipartFile multipartFile3,
                           HttpSession session,
                           HttpServletRequest request){

        String dynamic_photo=null;
        String dynamic_photo1=null;
        String dynamic_photo2=null;

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
                return "dev/index";
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
                    return "dev/index";
                }
                dynamic_photo="/statics/images/"+fileName;
            }
        }

        ///上传文件
        if (!multipartFile2.isEmpty()){//判断是否有上传文件
            //上传到什么地方
            String realPath = session.getServletContext().getRealPath("/statics/images/");
            System.out.println(realPath);
            //获得文件后缀
            String originalFilename = multipartFile2.getOriginalFilename();
            String suffix = FilenameUtils.getExtension(originalFilename);
            if(multipartFile2.getSize() >  500000){//上传大小不得超过 500k
                request.setAttribute("uploadFileError", " * 上传大小不得超过 500k");
                return "";
            }else if(suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png")
                    || suffix.equalsIgnoreCase("jpeg") || suffix.equalsIgnoreCase("pneg")) {//上传图片格式不正确

                String fileName = System.currentTimeMillis() + new Random().nextInt(1000000) + "_Personal.jpg";

                File targetFile = new File(realPath, fileName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                //保存
                try {
                    multipartFile2.transferTo(targetFile);
                } catch (Exception s) {
                    s.printStackTrace();
                    request.setAttribute("uploadFileError", " * 上传失败！");
                    return "";
                }
                dynamic_photo1="/statics/images/"+fileName;
            }
        }

        ///上传文件
        if (!multipartFile3.isEmpty()){//判断是否有上传文件
            //上传到什么地方
            String realPath = session.getServletContext().getRealPath("/statics/images/");
            System.out.println(realPath);
            //获得文件后缀
            String originalFilename = multipartFile3.getOriginalFilename();
            String suffix = FilenameUtils.getExtension(originalFilename);
            if(multipartFile3.getSize() >  500000){//上传大小不得超过 500k
                request.setAttribute("uploadFileError", " * 上传大小不得超过 500k");
                return "d";
            }else if(suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png")
                    || suffix.equalsIgnoreCase("jpeg") || suffix.equalsIgnoreCase("pneg")) {//上传图片格式不正确

                String fileName = System.currentTimeMillis() + new Random().nextInt(1000000) + "_Personal.jpg";

                File targetFile = new File(realPath, fileName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                //保存
                try {
                    multipartFile3.transferTo(targetFile);
                } catch (Exception s) {
                    s.printStackTrace();
                    request.setAttribute("uploadFileError", " * 上传失败！");
                    return "d";
                }
                dynamic_photo2="/statics/images/"+fileName;
            }
        }

        //获取用户信息
        Users user=(Users)session.getAttribute("users");
        String user_photo=user.getUser_photo();
        String user_name=user.getUser_name();
        String user_tid=user.getUser_tel();
        Dynamic dynamic=new Dynamic(user_name,user_photo,dynamic_text,dynamic_photo,user_tid,dynamic_photo1,dynamic_photo2);
        upLoadService.upload(dynamic);

        String user_tel=user.getUser_tel();
        String user_pass=user.getUser_pass();

        return "redirect:/Lf/dologin?user_tel="+user_tel+"&&user_pass="+user_pass;
    }


    @RequestMapping(value = "/delete")
    public String deltedy(@RequestParam(value = "dynamic_id") Integer dynamic_id){
        upLoadService.deleteDy(dynamic_id);
        commentService.deltetCom(dynamic_id);
        lfService.deletePra(dynamic_id);
        return "redirect:/Lf/touser";
    }
}
