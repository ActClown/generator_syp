package com.generator.syp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
* <p>Title: ConfigInfo</p>  
* <p>Description: </p>  
* @author syp  
* @date 2018年8月2日
 */
public class ConfigInfo implements Serializable {
	private static final long serialVersionUID = 123123L;
	/*
	 * 项目名称
	 */
	private String project;

	private String author;

	private String version;
	/*
	 * 数据库url
	 */
	private String dbUrl;
	/*
	 * 数据库账号
	 */
	private String dbName;

	private String dbPassword;
	/*
	 * 数据库名称
	 */
	private String database;
	/*
	 * 表名称
	 */
	private String table;
	/*
	 * 实体名称
	 */
	private String entityName;
	/*
	 * 对象名称
	 */
	private String objectName;
	/*
	 * 对象备注
	 */
	private String entityComment;

	private String createTime;
	/*
	 * 序列化
	 */
	private String agile;
	/*
	 * 生成的文件路径
	 */
	private String entityUrl;

	private String daoUrl;

	private String mapperUrl;

	private String serviceUrl;

	private String controllerUrl;

	private String jdbcDriver;
	/*
	 * 列相信息
	 */
	private List<ColumuInfo> columuInfos;

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(String entityComment) {
		this.entityComment = entityComment;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAgile() {
		return agile;
	}

	public void setAgile(String agile) {
		this.agile = agile;
	}

	public String getEntityUrl() {
		return entityUrl;
	}

	public void setEntityUrl(String entityUrl) {
		this.entityUrl = entityUrl;
	}

	public String getDaoUrl() {
		return daoUrl;
	}

	public void setDaoUrl(String daoUrl) {
		this.daoUrl = daoUrl;
	}

	public String getMapperUrl() {
		return mapperUrl;
	}

	public void setMapperUrl(String mapperUrl) {
		this.mapperUrl = mapperUrl;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getControllerUrl() {
		return controllerUrl;
	}

	public void setControllerUrl(String controllerUrl) {
		this.controllerUrl = controllerUrl;
	}

	public List<ColumuInfo> getColumuInfos() {
		return columuInfos;
	}

	public void setColumuInfos(List<ColumuInfo> columuInfos) {
		this.columuInfos = columuInfos;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}


	public ConfigInfo(String project, String author, String version, 
			String dbUrl,String dbName, String dbPassword,String database,
			String createTime, String agile, 
			String entityUrl, String daoUrl, String mapperUrl, String serviceUrl,String controllerUrl) {
		super();
		this.project = project;
		this.author = author;
		this.version = version;
		this.dbUrl = dbUrl;
		this.dbName = dbName;
		this.dbPassword = dbPassword;
		this.database = database;
		this.createTime = createTime;
		this.agile = agile;
		this.entityUrl = entityUrl;
		this.daoUrl = daoUrl;
		this.mapperUrl = mapperUrl;
		this.serviceUrl = serviceUrl;
		this.controllerUrl = controllerUrl;
	}
	
}
