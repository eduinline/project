<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basePackage}.controller.${oneDomain}.${twoDomain};

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airsky.usp.controller.common.BaseCRUDController;
import com.airsky.usp.controller.${oneDomain}.${twoDomain}.errorcode.I${className}ControllerError;
import com.airsky.usp.entities.${oneDomain}.${twoDomain}.${className};
import com.airsky.usp.entities.system.menus.Menus;
import com.airsky.usp.service.${oneDomain}.${twoDomain}.I${className}Service;
import com.framework.common.exception.ApplicationException;

@Controller
@RequestMapping("${oneDomain}/${twoDomain}")
public class ${className}Controller extends BaseCRUDController<${className}, ${table.idColumn.javaType}> implements I${className}ControllerError {
	
	@Autowired
	private I${className}Service ${classNameLower}Service;
	
	@Override
	protected boolean beforeSave(${className} m) {
		super.beforeSave(m);
		if(!${classNameLower}Service.checkUnique(m))
			throw new ApplicationException(SAVE_ERR_CODE_RUNTITME);
		m.setCreatedBy(getUserId());
		m.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		return Boolean.TRUE;
	}
	
	<#if mulLanguage=='Y'>
	protected void afterSave(${className} m) {
		${classNameLower}Service.insertLanguage(m);
	}
	</#if>
	
	@Override
	protected boolean beforeUpdate(${className} m) {
		super.beforeUpdate(m);
		if(!${classNameLower}Service.checkUnique(m))
			throw new ApplicationException(SAVE_ERR_CODE_RUNTITME);
		return Boolean.TRUE;
	}
	
	<#if mulLanguage=='Y'>
	protected void afterUpdate(${className} m) {
		${classNameLower}Service.updateLanguage(m);
	}
	</#if>
	
	<#if mulLanguage=='Y'>
	protected void afterDelete(Integer id) {
		menusService.deleteLanguage(id);
	}
	</#if>
	
	@Override
	protected void setCommonData(Model model) {
		super.setCommonData(model);
	} 
	
	@ResponseBody
	@RequestMapping(value = "/batchDelete")
	public void batchDelete(String ids) {
		try {
			List<Integer> idsList = new ArrayList<Integer>();
			String[] idsArr = ids.split(",");
			for (String id : idsArr) {
				idsList.add(Integer.valueOf(id));
			}
			${classNameLower}Service.batchDelete(idsList);
		} catch(Exception ex) {
			throw new ApplicationException(DELETE_ERR_CODE_RUNTITME, ex);
		}
	}
	
	@Override
	protected String getSaveErrorCode() {
		return SAVE_ERR_CODE_RUNTITME;
	}
	
	@Override
	protected String getUpdateErrorCode() {
		return UPDATE_ERR_CODE_RUNTITME;
	}
	
	@Override
	protected String getDeleteErrorCode() {
		return DELETE_ERR_CODE_RUNTITME;
	}
	
	@Override
	protected String getSearchErrorCode() {
		return SEARCH_ERR_CODE_RUNTITME;
	}
	
}