<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basePackage}.${oneDomain}.${twoDomain}.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airsky.usp.common.controller.BaseCRUDController;
import com.airsky.usp.${oneDomain}.${twoDomain}.controller.errorcode.I${className}ControllerError;
import com.airsky.usp.${oneDomain}.entities.${twoDomain}.${className};
import com.airsky.usp.${oneDomain}.service.${twoDomain}.I${className}Service;

import common.exception.ApplicationException;
import common.exception.ServiceException;
import common.util.Ognl;

@Controller
@RequestMapping("${oneDomain}/${twoDomain}")
public class ${className}Controller extends BaseCRUDController<${className}, ${table.idColumn.javaType}> implements I${className}ControllerError {
	
	@Autowired
	private I${className}Service ${classNameLower}Service;
	
	@Override
	protected boolean beforeSave(${className} m) {
		super.beforeSave(m);
		m.setCreatedBy("admin");
		m.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		return Boolean.TRUE;
	}
	
	@Override
	protected boolean beforeUpdate(${className} m) {
		super.beforeUpdate(m);
		return Boolean.TRUE;
	}
	
	
	@Override
	protected void setCommonData(Model model) {
		super.setCommonData(model);
	} 
	
	@ResponseBody
	@RequestMapping(value = "/batchDelete")
	public void batchDelete(String userIdStr) {
		try {
			List<Integer> userIdList = new ArrayList<Integer>();
			String[] userIds = userIdStr.split(",");
			for (String userId : userIds) {
				userIdList.add(Integer.valueOf(userId));
			}
			${classNameLower}Service.batchDelete(userIdList);
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