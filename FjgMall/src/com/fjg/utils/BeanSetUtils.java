package com.fjg.utils;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

/*
 *  MVC思想
 *  dao:
 *  service:
 *  servlet:HttpServletRequest  耦合度太高了
 */
public class BeanSetUtils {
	public static <T> T setAnyBean(Map<String, String[]> map,T bean) {
		//需要对BigDecimal做一个初始的值转换
		BigDecimalConverter big = new BigDecimalConverter(BigDecimal.ZERO);
		//类型转换
		ConvertUtils.register(big, java.math.BigDecimal.class);
		try {
			
			BeanUtils.populate(bean, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	
}
