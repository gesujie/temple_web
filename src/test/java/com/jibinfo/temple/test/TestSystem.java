package com.jibinfo.temple.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jibinfo.core.utils.PrintlnUtils;
import com.jibinfo.temple.entity.system.SystemWebsite;
import com.jibinfo.temple.service.system.ISystemWebsiteService;

@RunWith(SpringJUnit4ClassRunner.class)//是为Spring 3接入Junit 4框架，从Spring 3开始提供； 
@ContextConfiguration("classpath*:/applicationContext.xml")//是加载该类中使用的Bean所在的配置文件
public class TestSystem {
	@Autowired
	private ISystemWebsiteService systemWebsiteService;
	
	@Test
	public void selectExample(){
		SystemWebsite website = systemWebsiteService.selectByPrimaryKey(1L);
		PrintlnUtils.println(website);
	}
	
}
