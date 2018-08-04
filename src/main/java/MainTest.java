import java.sql.SQLException;
import java.util.Date;

import com.generator.syp.entity.ConfigInfo;
import com.generator.syp.service.Generator;
import com.generator.syp.utils.EntityInfoUtil;
import com.generator.syp.utils.MySqlToJavaUtil;

/** 
* @author syp
* @version 创建时间：2018年8月4日 下午1:48:39 
* 类说明 
*/
public class MainTest {
	//基础信息
	public static final String PROJECT="deal-center";
	public static final String AUTHOR="Act_su";
	public static final String VERSION="V1.0";
	//数据库连接信息
//	public static final String URL="jdbc:mysql://127.0.0.1:3306/sypblog?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true";
	public static final String JDBCDRIVER = "com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://127.0.0.1:3306/sypblog?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=true";
	public static final String NAME="root";
	public static final String PASSWORD="root";
	public static final String DATABASE="sypblog";
	//类信息
	public static final String TABLE="test";
	//类名可以设置
//	public static final String CLASSNAME="User";
	public static final String CLASSCOMMENT="用户信息";
	public static final String TIME=new Date().toString();
	public static final String AGILE=new Date().getTime()+"";
	//路径信息
	public static final String ENTITY_URL="com.suyupeng.entity";
	public static final String DAO_URL="com.suyupeng.dao";
	public static final String XML_URL="com.suyupeng.mapper";
	public static final String SERVICE_URL="com.suyupeng.service";
	public static final String CONTROLLER_URL="com.suyupeng.controller";
	
	public static void main(String []args) {
		ConfigInfo configInfo =  new ConfigInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASSWORD, 
				DATABASE, TIME, AGILE, ENTITY_URL, DAO_URL, XML_URL, SERVICE_URL,
					CONTROLLER_URL);
		
		configInfo.setTable(TABLE);
		configInfo.setEntityName(MySqlToJavaUtil.getClassNameBytableName(TABLE));
		configInfo.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
		configInfo.setEntityComment(CLASSCOMMENT);
		
		try {
			configInfo=EntityInfoUtil.getInfo(configInfo);
			String aa1=Generator.createEntity("E:\\BD\\gen\\java\\", configInfo).toString();
			System.out.println(aa1);
			/*String aa2=Generator.createDao("E:\\test_workspace\\mybatis-generator\\src\\main\\java\\", bi).toString();
			String aa3=Generator.createDaoImpl("E:\\test_workspace\\mybatis-generator\\src\\main\\java\\", bi).toString();
			String aa4=Generator.createService("E:\\test_workspace\\mybatis-generator\\src\\main\\java\\", bi).toString();
			String aa5=Generator.createServiceImpl("E:\\test_workspace\\mybatis-generator\\src\\main\\java\\", bi).toString();
			String aa6=Generator.createController("E:\\test_workspace\\mybatis-generator\\src\\main\\java\\", bi).toString();*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
