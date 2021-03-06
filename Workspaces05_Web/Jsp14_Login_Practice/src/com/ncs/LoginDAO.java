package com.ncs;

import static com.ncs.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	
	public Member selectOneMember(Connection conn, Member m) {
		
		conn = getConnection();
		
		String sql = " SELECT USERID, PASSWORD, USERNAME "
				   + " FROM LOGIN "
				   + " WHERE USERID = ? "
				   + " AND PASSWORD = ? ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, m.getUserId());
			pstm.setString(2, m.getPassword());
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setUserId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setUserName(rs.getString(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(conn);
		}
		return member;
	}
}
