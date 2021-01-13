package com.fjg.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/*
 * ��װ�Ĳ�ѯ�������ͨ�ò���
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
			//ռλ����ֵ
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i + 1, arr[i]);
			}
			rs = ps.executeQuery();
			//��ȡԪ���ݶ���
			ResultSetMetaData rsmd = rs.getMetaData();
			//��ȡԪ���ݵĳ���
			int columnCount = rsmd.getColumnCount();
			//�����������
			ArrayList<T> list = new ArrayList<T>();
			while (rs.next()) {
				//��ȡʵ��������
				T t = clz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					//ѭ����ȡ��ֵ
					Object columnValue = rs.getObject(i + 1);
					//ѭ����ȡÿһ�� ����
					String label = rsmd.getColumnLabel(i + 1);
					String lowerCase = label.toLowerCase();
					//���丳ֵ
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
