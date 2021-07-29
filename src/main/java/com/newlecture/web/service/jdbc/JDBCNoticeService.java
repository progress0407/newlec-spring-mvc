package com.newlecture.web.service.jdbc;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Service
public class JDBCNoticeService implements NoticeService {
    
    @Autowired
    private DataSource dataSource;
    
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Override
    public List<Notice> getList(int page, String field, String query) {
	
	int start = 1 + (page-1)*10; //1, 11, 21 ...
	int end = 10*page; // 10, 20, ...
	
//	String sql =  "SELECT * FROM NOTICE_VIEW WHERE " + field + " LIKE ? AND NUM BETWEEN ? AND ?" ;
	String sql =  "SELECT * FROM NOTICE";
	
	JdbcTemplate template = new JdbcTemplate();
	template.setDataSource(dataSource);
	List<Notice> list = template.query(sql, new BeanPropertyRowMapper<Notice>(Notice.class));
	
	
	return list;
    }

    @Override
    public int getCount() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int insert(Notice notice) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int update(Notice notice) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return 0;
    }
}
