/**
 * jibinfo
 * 2016-06-28-下午4:33:38
 * 2016南京坚卓软件科技有限公司-版权所有
 */
package com.jibinfo.temple.listenter;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lombok.extern.log4j.Log4j;

import com.jibinfo.core.global.Variable;
import com.jibinfo.core.utils.PropertiesUtils;
@Log4j
public class StartupListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		boolean result = initData();
		log.info("startup tomcat server and init data -------------->"+result);
	}

	/**
	 * @author Show_Ge
	 * @date 2016-3-10上午9:29:09
	 * @description
	 * 初始化服务器数据
	 * @return
	 */
	private boolean initData() {
		try {
			Variable.SYSTEM_PRINTLN = PropertiesUtils.getValueByProKey("system.properties", "println.level");
			Variable.ENV_KEY = PropertiesUtils.getValueByProKey("system.properties", "key");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	

}
