/**
 * @filename:${entityName} ${createTime}
 * @project ${project}  ${version}
 * @author ${author} 
 * All right reserved. 
 */
<#list columuInfos as ci>
	<#if ci.javaType == "Date">
import java.util.Date;
	<#elseif ci.javaType == "Blob">
import java.sql.Blob;	
	</#if>
</#list>
package ${entityUrl};


/**   
 *  
 * @Description:  ${entityComment}
 * @Author:       ${author}   
 * @CreateDate:   ${createTime}
 * @Version:      ${version}
 *    
 */

public class ${entityName} implements Serializable {

	private static final long serialVersionUID = ${agile}L;
	
<#list columuInfos as ci>
	private ${ci.javaType} ${ci.objProperty};
</#list>

	//属性get||set方法
	<#list columuInfos as ci>  
	public ${ci.javaType} get${ci.objProperty?cap_first}() {
		return this.${ci.objProperty};
	}
	public void set${ci.objProperty?cap_first}(${ci.javaType} ${ci.objProperty}) {
		this.${ci.objProperty} = ${ci.objProperty};
	}	
	</#list>

	/**无参构造方法**/	
	public ${entityName}(){};
	
	/**带参构造方法*/
	public ${entityName}(<#list columuInfos as ci>${ci.javaType} ${ci.objProperty}<#if ci_has_next>,<#else></#if></#list>){	
	<#list columuInfos as ci>  	
		this.${ci.objProperty} = ${ci.objProperty};
	</#list>
	}
}
	