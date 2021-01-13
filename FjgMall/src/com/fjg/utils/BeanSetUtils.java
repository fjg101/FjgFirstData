package com.fjg.utils;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

/*
 *  MVC˼��
 *  dao:
 *  service:
 *  servlet:HttpServletRequest  ��϶�̫����
 */
public class BeanSetUtils {
	public static <T> T setAnyBean(Map<String, String[]> map,T bean) {
		//��Ҫ��BigDecimal��һ����ʼ��ֵת��
		BigDecimalConverter big = new BigDecimalConverter(BigDecimal.ZERO);
		//����ת��
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
