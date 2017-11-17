package com.dmxiaoshen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaClientApplication.class, args);
	}


	@Configuration
	public class WebConfigBeans {
		@Autowired
		private RequestMappingHandlerAdapter handlerAdapter;

		/**
		 * 增加字符串转日期的功能
		 */
		@PostConstruct
		public void initEditableValidation() {
			ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter
					.getWebBindingInitializer();
			if (initializer.getConversionService() != null) {
				GenericConversionService genericConversionService = (GenericConversionService) initializer
						.getConversionService();
				genericConversionService.addConverter(String.class, Date.class, new String2DateConverter());
			}
		}

		/**
		 * 字符串转化成日期的适配，默认是Fri Nov 11 00:00:00 CST 1222 这种类型
		 * 这里填写需要支持的几种都行
		 */
		private class String2DateConverter implements Converter<String, Date> {
			@Override
			public Date convert(String source) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					return sdf.parse(source);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}
		}
	}
}
