package com.fjg.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fjg.dao.PageDao;
import com.fjg.pojo.Product;
import com.fjg.utils.JDBC_Druid_Util;
import com.fjg.utils.queryUtil;

public class PageDaoImpl implements PageDao{

	@Override
	public int pageCount() {
		// 分页记录数
		String sql = "select count(*) from f_product";
		Connection conn = JDBC_Druid_Util.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<Product> pageCurrent(Integer begin, Integer end) {
		// 分页内容
		String sql = "select id,f_user_id,product_name,product_price,product_sales,product_stock,product_img from (select id,f_user_id,product_name,product_price,product_sales,product_stock,product_img,rownum rm from f_product where rownum <=?) where rm>=?";
		List<Product> list = queryUtil.getInstance(Product.class, sql, end,begin);
		return list;
	}

	//名称搜索分页
	@Override
	public int pageNameCount(String product_name) {
		// 搜索分页记录数
		String sql = "select count(*) from f_product where f_product.product_name like ?";
		Connection conn = JDBC_Druid_Util.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "%"+product_name+"%");
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<Product> pageNameCurrent(Integer begin, Integer end, String product_name) {
		// 搜索分页内容
		String sql = "select id,f_user_id,product_name,product_price,product_sales,product_stock,product_img from (select id,f_user_id,product_name,product_price,product_sales,product_stock,product_img,rownum rm from f_product where rownum <=? and f_product.product_name like ?) where rm>=? ";
		List<Product> list = queryUtil.getInstance(Product.class, sql, end,"%"+product_name+"%",begin);
		return list;
	}

}
