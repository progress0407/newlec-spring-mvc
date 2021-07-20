package com.newlecture.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.jdbc.JDBCNoticeService;

public class ListController implements Controller {
    
    private JDBCNoticeService noticeService;
    
    public void setNoticeService(JDBCNoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	ModelAndView mv = new ModelAndView("notice.list");
//	mv.setViewName("/WEB-INF/view/notice/list.jsp");
	List<Notice> list = noticeService.getList(1, "TITLE", "");
	mv.addObject("list", list);
	
	for (Notice notice : list) {
	    System.out.println(notice);
	}
	
        return mv;
    }
}
