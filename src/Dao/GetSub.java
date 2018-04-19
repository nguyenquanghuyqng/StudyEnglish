package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnection;
import Model.Sub;

public class GetSub {

	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	public static void main(String[] args) {

	}

	public static List<Sub> GetListSub(int id) {
		List<Sub> listsub = new ArrayList<Sub>();

		// Khai báo biến cho thực hiện truy vấn
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not connect :" + e);
		}
		String sql = "Select content From sub where video_id="+id+"" ;
		
		try {
			// Chuẩn bị câu lệnh truy vấn
			stmt = conn.prepareStatement(sql);
			// Thực hiện câu lệnh truy vấn
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				Sub sub = new Sub();
				sub.setContent(rs.getString("content"));
				listsub.add(sub);
			}
		} catch (Exception ex) {
			System.err.println("Error get data video" + ex);
		}

		return listsub;
	}
	public static List<Sub> GetListTime(int id) {
		List<Sub> listtime = new ArrayList<Sub>();

		// Khai báo biến cho thực hiện truy vấn
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not connect :" + e);
		}
		String sql = "Select time From sub where video_id="+id+"" ;
		
		try {
			// Chuẩn bị câu lệnh truy vấn
			stmt = conn.prepareStatement(sql);
			// Thực hiện câu lệnh truy vấn
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				Sub sub = new Sub();
				
				sub.setTime(rs.getString("time"));
				
				listtime.add(sub);
			}
		} catch (Exception ex) {
			System.err.println("Error get data video" + ex);
		}

		return listtime;
	}
}
