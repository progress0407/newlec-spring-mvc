package com.newlecture.web.service.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

public class JPANoticeService implements NoticeService {
    
    private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private String uid = "philz";
    private String pwd =  "1234";
    private String driver =  "oracle.jdbc.driver.OracleDriver";
    
    @Override
    public List<Notice> getList(int page, String field, String query) {
	
	int start = 1 + (page-1)*10; //1, 11, 21 ...
	int end = 10*page; // 10, 20, ...
	
	String sql =  "SELECT * FROM NOTICE_VIEW WHERE " + field + " LIKE ? AND NUM BETWEEN ? AND ?" ;
	
	try {
	    Class.forName(driver);
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	}
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	try {
	    con = DriverManager.getConnection(url, uid, pwd);
	    st = con.prepareStatement(sql);
	    st.setString(1, "%" + query + "%");
	    st.setInt(2, start);
	    st.setInt(3, end);
	    rs = st.executeQuery();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	Notice notice;
	List<Notice> list = new ArrayList<>();
	
	try {
	    while(rs.next()) {
	        int id = rs.getInt("ID");
	        String title = rs.getString("TITLE");
	        Date regdate = rs.getDate("REGDATE");
	        String writerId = rs.getString("WRITER_ID");
	        int hit = rs.getInt("HIT");
	        String files = rs.getString("FILES");
	        String content = rs.getString("CONTENT");
	        int pub = rs.getInt("pub");
	        
	        notice = new Notice(id, title, regdate, writerId, hit, files, content, pub);
	        list.add(notice);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	
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
