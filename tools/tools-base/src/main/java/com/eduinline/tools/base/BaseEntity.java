package com.eduinline.tools.base;

import java.util.Date;

/**
 * <p>基础实体类，所有的对象实体继承BaseEntity</p>
 * <ul>
 * 	<li>提供了4个公共属性：主键(uuid)、语言代码(lanCode)、创建人(createdBy)和创建时间(createdDate)</li>
 * </ul>
 * @version 1.0 2016年8月17日-上午11:32:03
 * @author hongze.he@eduinline.com
 */
public class BaseEntity implements java.io.Serializable {

	/** 序列版本ID */
	private static final long serialVersionUID = 4181841364412338665L;
	
	/** 主键，统一使用UUID */
	private String uuid;
	
	/** 语言代码，默认简体中文zh-CN */
	private String lanCode = "zh-CN";
	
	/** 创建人 */
	private String createdBy;
	
	/** 创建时间 */
	private Date createdTime;


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLanCode() {
		return lanCode;
	}

	public void setLanCode(String lanCode) {
		this.lanCode = lanCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
}
