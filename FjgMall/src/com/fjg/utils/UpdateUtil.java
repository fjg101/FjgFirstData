package com.fjg.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/*
 * ��װ����ɾ��
 */
public class UpdateUtil {
	//java5���ֵ������ԣ��пɱ䳤�ȵ��б� ����0-object
	public static int update(String sql,Object ...arr) {
//		System.out.println("sql==>"+sql);
		//1.��ȡ����
		Connection conn = null;
		PreparedStatement ps=null;
		int sum=0;
		try {
			conn = JDBC_Druid_Util.getConnection();
//			System.out.println(conn+"�õ���~");
			ps = conn.prepareStatement(sql);
			//��ռλ������
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i+1, arr[i]);
			}
			//ִ��
			sum = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return sum;
		}
		//�ر�
		JDBC_Druid_Util.closeConnection(conn, ps);
		return sum;
	}
}
