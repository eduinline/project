<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basePackage}.controller.${oneDomain}.${twoDomain};

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airsky.usp.controller.common.BaseCRUDController;
import com.airsky.usp.controller.${oneDomain}.${twoDomain}.errorcode.I${className}ControllerError;
import com.airsky.usp.dto.system.language.MulLanDto;
import com.airsky.usp.dto.system.language.MulLanModel;
import com.airsky.usp.entities.${oneDomain}.${twoDomain}.${className};
import com.airsky.usp.entities.system.languagetype.LanguageType;
import com.airsky.usp.entities.system.menus.Menus;
import com.airsky.usp.service.${oneDomain}.${twoDomain}.I${className}Service;
import com.airsky.usp.service.system.languagetype.ILanguageTypeService;
import com.framework.common.exception.ApplicationException;

@Controller
@RequestMapping("${oneDomain}/${twoDomain}")
public class ${className}Controller extends BaseCRUDController<${className}, ${table.idColumn.javaType}> 
implements I${className}ControllerError {
	
	@Autowired
	private I${className}Service ${classNameLower}Service;
	<#if mulLanguage=='Y'>
	@Resource
	private ILanguageTypeService languageTypeService;
	</#if>
	
	@Override
	protected boolean beforeSave(${className} m) {
		super.beforeSave(m);
		if(!${classNameLower}Service.checkUnique(m))
			throw new ApplicationException(SAVE_ERR_CODE_RUNTITME);
		m.setCreatedBy(getUserId());
		m.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		return Boolean.TRUE;
	}
	
	@Override
	protected boolean beforeUpdate(${className} m) {
		super.beforeUpdate(m);
		if(!${classNameLower}Service.checkUnique(m))
			throw new ApplicationException(SAVE_ERR_CODE_RUNTITME);
		return Boolean.TRUE;
	}
	
	<#if mulLanguage=='Y'>
	protected void afterSave(${className} m, ${table.idColumn.javaType} id) {
		m.setId(id);
		${classNameLower}Service.insertLanguage(m, m.getLanCode());
	}
	
	protected void afterUpdate(${className} m) {
		${classNameLower}Service.updateLanguage(m);
	}
	
	protected boolean beforDelete(${table.idColumn.javaType} id) {
		super.beforDelete(id);
		${classNameLower}Service.deleteLanguage(id);
		return true;
	}
	
	@RequestMapping(value = "/mullan/{id}/{field}")
	public String showMullan(@PathVariable("id") ${table.idColumn.javaType} id, 
			@PathVariable("field") String field, Model model) {
		model.addAttribute("field", field);
		model.addAttribute("preURL", getRequestMapping());
		List<MulLanDto> mulLanList = ${classNameLower}Service.findMulLanById(id, field);
		List<LanguageType> typeList = languageTypeService.findAll();
		if(mulLanList.size()<typeList.size()){
			${className} m = ${classNameLower}Service.get(id);
			List<String> exists = new ArrayList<String>();
			for (MulLanDto mulLanDto : mulLanList) {
				exists.add(mulLanDto.getLanCode());
			}
			for (LanguageType languageType : typeList) {
				if(!exists.contains(languageType.getCode())){
					${classNameLower}Service.insertLanguage(m, languageType.getCode());
				}
			}
			mulLanList = ${classNameLower}Service.findMulLanById(id, field);
		}
		model.addAttribute("mulLanList", mulLanList);
		setCommonData(model);
		return "system/languagetype/mulLanEdit";
	}
	
	/**
	 * 更新多语言
	 */
	@ResponseBody
	@RequestMapping(value = "/mullan", method = RequestMethod.POST)
	public final void upadteMulLan(MulLanModel mulLanModel) {
		${classNameLower}Service.upadteMulLan(mulLanModel);
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