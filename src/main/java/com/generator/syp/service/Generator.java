package com.generator.syp.service;

import java.util.List;

import com.generator.syp.entity.ColumuInfo;
import com.generator.syp.entity.ConfigInfo;
import com.generator.syp.entity.ExecuteResult;
import com.generator.syp.utils.EntityInfoUtil;
import com.generator.syp.utils.FreemarkerUtil;
/** 
* @author syp
* @version 创建时间：2018年8月4日 下午1:30:37 
* 类说明 
*/
public class Generator {
	//路径信息
	public static final String ENTITY="entity";
	public static final String DAO="dao";
	public static final String DAO_IMPL="daoImpl";
	public static final String SERVICE="service";
	public static final String CONTROLLER="controller";
	
	//①创建实体类
	public static ExecuteResult createEntity(String url,ConfigInfo configInfo) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, configInfo.getEntityUrl(), configInfo.getEntityName(), ENTITY);
		return FreemarkerUtil.createFile(configInfo, "entity.ftl", fileUrl);
	}
	
	//②创建DAO
	public static ExecuteResult createDao(String url,ConfigInfo configInfo) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, configInfo.getDaoUrl(), configInfo.getEntityName(), DAO);
		return FreemarkerUtil.createFile(configInfo, "dao.ftl", fileUrl);
	}
	
	//③创建mapper配置文件
	public static ExecuteResult createDaoImpl(String url,ConfigInfo configInfo) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, configInfo.getMapperUrl(), configInfo.getEntityName(), DAO_IMPL);
		List<ColumuInfo> list=configInfo.getColumuInfos();
		String agile="";
		for (ColumuInfo columuInfo: list) {
			agile=agile+columuInfo.getColumnName()+", ";
		}
		agile=agile.substring(0, agile.length()-2);
		configInfo.setAgile(agile);
		return FreemarkerUtil.createFile(configInfo, "mapper.ftl", fileUrl);
	}
	
	//④创建SERVICE
	public static ExecuteResult createService(String url,ConfigInfo configInfo) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, configInfo.getServiceUrl(), configInfo.getEntityName(), SERVICE);
		return FreemarkerUtil.createFile(configInfo, "service.ftl", fileUrl);
	}
	
	//⑥创建CONTROLLER
	public static ExecuteResult createController(String url,ConfigInfo configInfo) {
		String fileUrl= EntityInfoUtil.getGeneratorFileUrl(url, configInfo.getControllerUrl(), configInfo.getEntityName(), CONTROLLER);
		return FreemarkerUtil.createFile(configInfo, "controller.ftl", fileUrl);
	}
}
