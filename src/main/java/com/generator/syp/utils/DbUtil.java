package com.generator.syp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * <p>
 * Title: DbUtil
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author syp
 * @date 2018年8月4日
 */
public class DbUtil {

	public static Connection conn;
	public static PreparedStatement psmt;

	/**
	 * 
	 * <p>
	 * Title: getConn
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param DriverName
	 * @param url
	 * @param user
	 * @param password
	 * @return
	 */
	private static Connection getConn(String DriverName, String url, String user, String password) {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName(DriverName);
				conn = DriverManager.getConnection(url, user, password);
			}
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * <p>
	 * Title: executeQuery
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param sql
	 * @param DriverName
	 * @param url
	 * @param user
	 * @param password
	 * @param parms
	 * @return
	 */
	public static ResultSet executeQuery(String sql, String DriverName, String url, String user, String password,
			Object... parms) {
		try {
			psmt = getConn(DriverName, url, user, password).prepareStatement(sql);
			for (int i = 0; i < parms.length; i++) {
				psmt.setObject(i + 1, parms[i]);
			}
			return psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
