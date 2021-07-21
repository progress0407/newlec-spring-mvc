package com.newlecture.web.service;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.entity.Notice;

public interface NoticeService {
    
    public List<Notice> getList(int page, String field, String query);
    int getCount() throws ClassNotFoundException, SQLException;
    int insert(Notice notice) throws ClassNotFoundException, SQLException;
    int update(Notice notice) throws ClassNotFoundException, SQLException;
    int delete(int id) throws ClassNotFoundException, SQLException;
    
}
