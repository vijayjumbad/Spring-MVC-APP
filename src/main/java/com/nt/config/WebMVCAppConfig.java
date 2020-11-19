package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
//@PropertySource(value ="com/nt/commons/ErrorMsg" )
public class WebMVCAppConfig {
	
	@Bean//(name="messageSource") here 'messageSource' is a fix bean id 
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource source=new ResourceBundleMessageSource();
		source.addBasenames("com/nt/commons/ErrorMsg");
		return source;
	}

}
