package com.dmxiaoshen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignFormatterRegistrar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudEurekaConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaConsumerFeignApplication.class, args);
    }

    /**
     * fegin 调用传日期参数是默认 Fri Nov 11 00:00:00 CST 1222 这种类型
     * 这里自定义格式化，但是需要服务方能转化这种格式
     */
    @Component
    public class DateFormatRegister implements FeignFormatterRegistrar {
        public DateFormatRegister() {

        }

        @Override
        public void registerFormatters(FormatterRegistry registry) {
            registry.addConverter(Date.class, String.class, new Date2StringConverter());
        }

        private class Date2StringConverter implements Converter<Date, String> {
            @Override
            public String convert(Date source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return sdf.format(source);
            }

        }
    }
}
