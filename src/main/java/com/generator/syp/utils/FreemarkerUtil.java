package com.generator.syp.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.generator.syp.entity.ConfigInfo;
import com.generator.syp.entity.ExecuteResult;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * <p>
 * Title: FreemarkerUtil
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author syp
 * @date 2018年8月4日
 */
public class FreemarkerUtil {

	/**
	 * 
	 * <p>
	 * Title: createFile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param dataModel
	 *            templateName filePath
	 * @return ExecuteResult 执行结果
	 */
	public static ExecuteResult createFile(ConfigInfo dataModel, String templateName, String filePath) {
		ExecuteResult result = new ExecuteResult();
		FileWriter out = null;
		/*
		 * 文件名称
		 */
		String fileName = dataModel.getEntityName() + getprefix(templateName);
		try {
			// 通过FreeMarker的Confuguration读取相应的模板文件
			Configuration configuration = new Configuration();
			// 设置模板路径
			configuration.setClassForTemplateLoading(FreemarkerUtil.class, "/templates/ftl");
			// 设置默认字体
			configuration.setDefaultEncoding("utf-8");
			// 获取模板
			Template template = configuration.getTemplate(templateName);
			File file = new File(filePath);
			// 创建父级目录
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			// 判断文件是否存在 并创建
			if (!file.exists()) {
				file.createNewFile();
			} else {
				result.setCode(-1);
				result.setMessage(fileName + "  已经存在");
				return result;
			}
			// 设置输出流
			out = new FileWriter(file);
			// 模板输出静态文件
			template.process(dataModel, out);
			result.setCode(1);
			result.setMessage("创建" + fileName + "成功");
			return result;
		} catch (Exception e) {
			// 异常捕获
			e.printStackTrace();
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private static String getprefix(String name) {
		if (name.equals("entity.ftl")) {
			name = ".java";
		} else if (name.equals("dao.ftl")) {
			name = "Dao.java";
		} else if (name.equals("mapper.ftl")) {
			name = "Mapper.xml";
		} else if (name.equals("service.ftl")) {
			name = "Service.java";
		} else if (name.equals("controller.ftl")) {
			name = "Controller.java";
		}
		return name;
	}
}
