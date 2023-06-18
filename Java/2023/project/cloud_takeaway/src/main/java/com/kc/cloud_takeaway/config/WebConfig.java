package com.kc.cloud_takeaway.config;

import com.kc.cloud_takeaway.common.JacksonObjectMapper;
import com.kc.cloud_takeaway.handler.LoginIntercept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Configuration
public class WebConfig  implements WebMvcConfigurer {
    @Resource
    private LoginIntercept loginIntercept;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(loginIntercept).addPathPatterns("/**")
                .excludePathPatterns("/employee/login")
                .excludePathPatterns("/employee/page")
                .excludePathPatterns("/employee/logout");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始进行静态资源映射...");
        registry.addResourceHandler("/static/backend/**").addResourceLocations("classpath:/static/backend/");
        registry.addResourceHandler("/static/front/**").addResourceLocations("classpath:/static/front/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器...");
        //创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        //设置对象转换器，底层使用Jackson将Java对象转为json
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //将上面的消息转换器对象追加到mvc框架的转换器集合中
        converters.add(0,messageConverter);
    }
}
