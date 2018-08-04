package com.generator.syp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.generator.syp.entity.ColumuInfo;
import com.generator.syp.entity.ConfigInfo;

/**
 * @author syp
 * @version 创建时间：2018年8月4日 下午12:40:21 类说明
 */
public class EntityInfoUtil {
	
	/**
	 * 
	* <p>Title: getInfo</p>  
	* <p>Description: </p>  
	* @param configInfo
	* @return
	* @throws SQLException
	 */
	public static ConfigInfo getInfo(ConfigInfo configInfo) throws SQLException {
		List<ColumuInfo> columns = new ArrayList<ColumuInfo>();
		// 创建连接
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// sql
		String sql="select column_name,data_type,column_comment from "
				+ " information_schema.columns where "
				+ " table_schema='"+configInfo.getDatabase()+"' and table_name='"+configInfo.getTable()+"'";
		try {
			conn = DriverManager.getConnection(configInfo.getDbUrl(), configInfo.getDbName(), configInfo.getDbPassword());
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery(sql);
			// 将查询结果装箱
			while (rs.next()) {
				String column = rs.getString(1);
				String columnType = rs.getString(2);
				String comment = rs.getString(3);
				ColumuInfo ci = new ColumuInfo();

				ci.setColumnName(column);
				ci.setColComment(comment);
				ci.setColumnType(columnType);
				ci.setJavaType(MySqlToJavaUtil.jdbcTypeToJavaType(columnType));
				ci.setObjProperty(MySqlToJavaUtil.changeToJavaFiled(column));
				columns.add(ci);
			}
			configInfo.setColumuInfos(columns);
			return configInfo;
		} catch (Exception e) {
			throw new RuntimeException("自动生成实体类错误：" + e.getMessage());
		} finally {
			psmt.close();
			conn.close();
		}
	}
	
	/**
	 * 
	* <p>Title: getGeneratorFileUrl</p>  
	* <p>Description: 生成文件路径</p>  
	* @param url
	* @param packageUrl
	* @param entityName
	* @param type
	* @return
	 */
	public static String getGeneratorFileUrl(String url,String packageUrl,String entityName, String type){
		if (type.equals("entity")) {
			return url+pageToUrl(packageUrl)+entityName+".java";
		}else if(type.equals("dao")) {
			return url+pageToUrl(packageUrl)+entityName+"Dao.java";
		}else if(type.equals("daoImpl")) {
			return url+pageToUrl(packageUrl)+entityName+"Mapper.xml";
		}else if(type.equals("service")) {
			return url+pageToUrl(packageUrl)+entityName+"Service.java";
		}else if(type.equals("controller")) {
			return url+pageToUrl(packageUrl)+entityName+"Controller.java";
		}
		return null;
	}
	
	/**
	 * 
	* <p>Title: pageToUrl</p>  
	* <p>Description: 解析包名</p>  
	* @param url
	* @return
	 */
	public static String pageToUrl(String url) {
		return url.replace(".", "/")+"/";
	}
}
