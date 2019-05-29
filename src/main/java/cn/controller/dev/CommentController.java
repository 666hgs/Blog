package main.java.cn.controller.dev;

import main.java.cn.pojo.*;
import main.java.cn.service.dev.CommentService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import main.java.cn.service.dev.LfService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping(value = "/Comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private LfService lfService;



    //根据动态id跳转到评论页面
    @RequestMapping(value = "/comment")
    public String getCommentList(HttpServletRequest request,
                                 HttpSession session,
                                 @RequestParam(value = "dynamic_id")int dynamic_id){
        //获取评论(父评论)列表
        List<Comment> commentList;
        commentList=commentService.getCommentList(dynamic_id);
        //获取回复(子评论)列表
        List<Soncomment> soncommentList;
        soncommentList=commentService.getSonCommentList();
        //将相同CommentId的子评论放到父评论中
        List<Soncomment> soncommentList2=new ArrayList<Soncomment>();
        Soncomment soncomment;
        for (int i=0;i<commentList.size();i++){
            for(int x=0;x<soncommentList.size();x++){
                if(commentList.get(i).getCommentId()==soncommentList.get(x).getCommentId()){
                    soncommentList2.add(soncommentList.get(x));
                }
            }
            commentList.get(i).setSoncommentList(soncommentList2);
            soncommentList2=new ArrayList<Soncomment>();
        }
        request.setAttribute("commentList",commentList);

        //判断是否点过赞
        Users user=(Users)session.getAttribute("users");
        Dynamic dynamic=commentService.getDynamic(dynamic_id);
        List<Praise> praiseList = lfService.findPraiselist(user.getUser_tel(), dynamic_id);
        int sizes = praiseList.size();
        dynamic.setSize(sizes);


        //获取评论总条数
        int num=commentService.getCommentNum(dynamic_id);
        int good=lfService.findCount(dynamic_id);
        request.setAttribute("num",num);
        request.setAttribute("good",good);
        request.setAttribute("dynamic_Id",dynamic_id);
        request.setAttribute("dynamic",dynamic);
        return "dev/comment";
    }

    //插入父评论
    @RequestMapping(value = "/addComment.json")
    @ResponseBody
    public Object addComment(HttpServletRequest request,
                             @RequestParam(value = "comment")String comment,
                             @RequestParam(value = "dynamic_Id")int dynamic_Id,
                             HttpSession session){
        Map<String,Object> commentObjectHashMap = new HashMap<>();
        //获取当前时间
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        //将所有属性放到Comment对象，然后插入
        Users users=(Users)session.getAttribute("users");
        String photo= users.getUser_photo();
        String name=users.getUser_name();
        Comment comment1=new Comment(comment,name,photo,time,dynamic_Id);
        commentService.addComment(comment1);
        List<Comment> commentList=commentService.getCommentList(dynamic_Id);
        Comment comment2=commentList.get(commentList.size()-1);
        commentObjectHashMap.put("comment2",comment2);
        int num=commentService.getCommentNum(dynamic_Id);
        commentObjectHashMap.put("num",num);
        return JSONObject.toJSONString(commentObjectHashMap);
    }

    //插入子评论
    @RequestMapping(value = "/addSonComment.json")
    @ResponseBody
    public Object addSonComment(HttpServletRequest request,
                                @RequestParam(value = "sonComment")String sonComment,
                                @RequestParam(value = "commentId")int commentId,
                                @RequestParam(value = "othername")String othername,
                                @RequestParam(value = "dynamic_Id")int dynamic_Id,
                                HttpSession session){
        Map<String,Object> sonCommentObjectHashMap = new HashMap<>();
        //获取当前时间
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        //将所有属性放到Soncomment对象，然后插入
        Users users=(Users) session.getAttribute("users");
        String myname= users.getUser_name();
        Soncomment soncomment=new Soncomment(myname,othername,sonComment,time,commentId);
        commentService.addSonComment(soncomment);
        List<Soncomment> soncommentList=commentService.getSonCommentList();
        Soncomment soncomment1= soncommentList.get(soncommentList.size()-1);
        sonCommentObjectHashMap.put("soncomment1",soncomment1);
        int num=commentService.getCommentNum(dynamic_Id);
        sonCommentObjectHashMap.put("num",num);
        return JSONObject.toJSONString(sonCommentObjectHashMap);
    }


}
