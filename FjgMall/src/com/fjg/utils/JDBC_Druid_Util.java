package com.fjg.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//德鲁伊druid连接池的工具类
public class JDBC_Druid_Util {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties pis = new Properties();
			InputStream inputStream = JDBC_Druid_Util.class.getClassLoader().getResourceAsStream("druid.properties");
			pis.load(inputStream);
			DataSource source = DruidDataSourceFactory.createDataSource(pis);
			conn = source.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//关闭
	public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void closeConnection(Connection conn) {
		// TODO Auto-generated method stub
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void closeConnection(Connection conn, PreparedStatement ps) {
		try {
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
