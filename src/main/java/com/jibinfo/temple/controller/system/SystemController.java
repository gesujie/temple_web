/**
 * jibinfo
 * 2016-06-28-下午4:33:38
 * 2016南京坚卓软件科技有限公司-版权所有
 */
package com.jibinfo.temple.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jibinfo.core.controller.BaseController;
import com.jibinfo.core.utils.PropertiesUtils;
import com.jibinfo.core.vo.JsonResult;
import com.jibinfo.core.vo.Paginator;
import com.jibinfo.temple.entity.system.SystemAdminUser;
import com.jibinfo.temple.entity.system.SystemWebsite;
import com.jibinfo.temple.entity.system.SystemWebsiteExample;
import com.jibinfo.temple.service.system.ISystemWebsiteService;


@Log4j
@Controller
@RequestMapping("/system")
public class SystemController extends BaseController{
	@Autowired
	private ISystemWebsiteService systemWebsiteService;
	
	
	@RequestMapping("/list")
	public String toIndex(HttpServletRequest request){
		String envKey = PropertiesUtils.getValueByProKey("system.properties", "key");
		log.info(envKey);
		SystemWebsite website = systemWebsiteService.selectByPrimaryKey(1L);
		log.info(website.toString());
		return "system/index";
	}
	
	@RequestMapping("/ajax")
	@ResponseBody
	public SystemAdminUser ajax(){
		try {
			systemWebsiteService.saveExp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public JsonResult page(){
		JsonResult result = super.getRespData();
		SystemWebsiteExample paramExample = new SystemWebsiteExample();
		Paginator paginator = super.setPaginator(1, 20);
		paramExample.setPaginator(paginator);
		List<SystemWebsite> list = systemWebsiteService.selectByExample(paramExample);
		Integer count = systemWebsiteService.countByExample(paramExample);
		result.setData(list);
		log.info(paginator.toString());
		log.info(count);
		log.info(list.toString());
		return result;
	} 
	
	
	
	
	
}
