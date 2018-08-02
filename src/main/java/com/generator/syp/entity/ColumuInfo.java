package com.generator.syp.entity;

/**
 * 
* <p>Title: ColumuInfo</p>  
* <p>Description: </p>  
* @author syp  
* @date 2018年8月2日
 */
public class ColumuInfo {
    
    private static final long serialVersionUID = 123124L;
	/**
	 * 列名
	 */
    private String columnName;
    /**
     * 数据类型
     */
    private String dataType;
	/**
	 * 列描述 
	 */
    private String Colcomment;
	/**
	 * 类属性 
	 */
    private String Objproperty;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getColcomment() {
		return Colcomment;
	}
	public void setColcomment(String colcomment) {
		Colcomment = colcomment;
	}
	public String getObjproperty() {
		return Objproperty;
	}
	public void setObjproperty(String objproperty) {
		Objproperty = objproperty;
	}
    
}
