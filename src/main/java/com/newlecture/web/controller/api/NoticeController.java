package com.newlecture.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@RestController("apiNoticeController")
@RequestMapping("/api/notice/")
public class NoticeController {
    
    @Autowired
    private NoticeService service;
    
    @RequestMapping("list")
    public List<Notice> list( ) {
	
	List<Notice> list = service.getList(1, "TITLE", "");
	
	return list;
    }
    
    @RequestMapping("justOne")
    public Notice justOne( ) {
	
	Notice jstOne = service.getList(1, "TITLE", "").get(0);
	
	return jstOne;
    }
}
