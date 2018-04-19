package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnection;
import Model.Sub;
import Model.Video;

public class GetSub {

	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	public static void main(String[] args) {

	}

	public static List<Sub> GetListSub() {
		List<Sub> listsub = new ArrayList<Sub>();

		// Khai báo biến cho thực hiện truy vấn
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not connect :" + e);
		}
		String sql = "Select * From sub";
		
		try {
			// Chuẩn bị câu lệnh truy vấn
			stmt = conn.prepareStatement(sql);
			// Thực hiện câu lệnh truy vấn
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				Sub sub = new Sub();
				
				sub.setId(rs.getInt("id"));
				sub.setContent(rs.getString("content"));
				sub.setContent_internation(rs.getString("content_internation"));
				sub.setTime(rs.getTime("time"));
				sub.setId(rs.getInt("video_id"));
				
				listsub.add(sub);
			}
		} catch (Exception ex) {
			System.err.println("Error get data video" + ex);
		}

		return listsub;
	}
}
