package com.fjg.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/*
 * 封装的查询任意类的通用操作
 */
public class queryUtil {
	public static <T>List<T> getInstance(Class<T> clz,String sql,Object ...arr){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			conn = JDBC_Druid_Util.getConnection();
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			//占位符赋值
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i + 1, arr[i]);
			}
			rs = ps.executeQuery();
			//获取元数据对象
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取元数据的长度
			int columnCount = rsmd.getColumnCount();
			//定义数组接收
			ArrayList<T> list = new ArrayList<T>();
			while (rs.next()) {
				//获取实例化对象
				T t = clz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					//循环获取列值
					Object columnValue = rs.getObject(i + 1);
					//循环获取每一列 列名
					String label = rsmd.getColumnLabel(i + 1);
					String lowerCase = label.toLowerCase();
					//反射赋值
					Field field = clz.getDeclaredField(lowerCase);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				list.add(t);
			} 
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBC_Druid_Util.closeConnection(conn, ps, rs);
		}
		return null;
	}
}
