package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
    
    @Autowired
    private ServletContext ctx;
    
    @Autowired
    private HttpServletRequest request;

    
    @RequestMapping("list")
    public String list(HttpServletRequest request) {
	return "admin.board.notice.list";
    }
    
    
    @GetMapping("reg")
    public String reg() {
	return "admin.board.notice.reg";
    }
    
    @PostMapping("reg")
    public String reg(
//	    HttpServletRequest request, 
	    String title, 
	    String content, 
	    MultipartFile[] files, 
	    String category, 
	    @RequestParam("back-exercises") String[] backExercises, 
	    @RequestParam("rd-back-exercise") String rdBackExercise
	    ) throws IllegalStateException, IOException {
	
	for (MultipartFile file : files) {
	    String fileName = file.getOriginalFilename();
	    long fileSize = file.getSize();
	    
	    System.out.printf("fileName : %s , fileSize : %d \n", fileName, fileSize);
	    
	    String webPath = "/static/upload";
	    String realPath = ctx.getRealPath(webPath);
	    
	    System.out.printf("realPath : %s \n", realPath);
	    
	    File savePath = new File(realPath);
	    
	    
	    if(!savePath.exists()) {
		savePath.mkdirs();
	    }
	    
	    realPath += File.separator + fileName;
	    File saveFile = new File(realPath);
	    
	    file.transferTo(saveFile);
	}
	
	
	for (String backExercise : backExercises) {
	    System.out.println(backExercise);
	}
	
//	return String.format("title : %s <br>  content : %s <br> category : %s", title, content, category);
	return "redirect:list";
    }
    
    
    @RequestMapping("edit")
    public String edit() {
	return "admin.board.notice.edit";
    }
    
//    @RequestMapping("del")
//    public String del() {
//	return "admin.board.notice.del";
//    }
}
