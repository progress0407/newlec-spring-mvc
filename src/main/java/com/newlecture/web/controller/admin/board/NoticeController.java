package com.newlecture.web.controller.admin.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
    
    @RequestMapping("list")
    public String list() {
	
	
    }
    
    @RequestMapping("reg")
    @ResponseBody
    public String reg(String title, String content, String category) {
	
	return String.format("title : %s <br>  content : %s <br> category : %s", title, content, category);
    }
    
    @RequestMapping("edit")
    public String edit() {
	
    }
    
    @RequestMapping("del")
    public String del() {
	
    }
}
