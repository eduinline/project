<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basePackage}.service.${oneDomain}.${twoDomain};

import java.util.List;

import ${basePackage}.entities.${oneDomain}.${twoDomain}.${className};
import ${basePackage}.dto.mullan.MulLanDto;
import ${basePackage}.dto.mullan.MulLanModel;
import com.framework.service.base.ICrudService;

public interface I${className}Service extends ICrudService<${className}, ${table.idColumn.javaType}>{
	
	/**
	 * 批量删除
	 */
	void batchDelete(List<${table.idColumn.javaType}> ids);
	
	/**
	 * <p>检查是否唯一</p>
	 * @param m 校验对象
	 * @return true=唯一；false=不唯一
	 */
	boolean checkUnique(${className} m);
	
	/**
	 * 新增多语言处理
	 * @param m 需要处理的对象
	 */
	void insertLanguage(${className} m, String lanCode);
	
	/**
	 * 获取某条记录的多语言值
	 * @param id 主键ID
	 * @param field 多语言字段
	 * @return List<MulLanDto>
	 */
	List<MulLanDto> findMulLanById(${table.idColumn.javaType} id, String field);

	/**
	 * 更新多语言数据
	 * @param mulLanModel
	 */
	void upadteMulLan(MulLanModel mulLanModel);
	
}
