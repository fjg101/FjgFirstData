package com.fjg.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/*
 * 封装的增删改
 */
public class UpdateUtil {
	//java5出现的新特性，叫可变长度的列表 代表0-object
	public static int update(String sql,Object ...arr) {
//		System.out.println("sql==>"+sql);
		//1.获取连接
		Connection conn = null;
		PreparedStatement ps=null;
		int sum=0;
		try {
			conn = JDBC_Druid_Util.getConnection();
//			System.out.println(conn+"拿到了~");
			ps = conn.prepareStatement(sql);
			//将占位符填上
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i+1, arr[i]);
			}
			//执行
			sum = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return sum;
		}
		//关闭
		JDBC_Druid_Util.closeConnection(conn, ps);
		return sum;
	}
}
