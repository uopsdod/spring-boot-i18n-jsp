package com.spring;


import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
 * Normally you would add @EnableWebMvc for a Spring MVC app, 
 * but Spring Boot adds it automatically when it sees spring-webmvc on the classpath.
 * That is, if you add "spring-boot-starter-web" as depedency, @SpringBootApplication will set up DispatcherServlet for us
 */
//@EnableWebMvc
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{  

	// 載入檔案設定
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations(
                "/resources/");
    }
    
    // 導頁設定
    @Bean
    public ViewResolver setupViewResolver() {
        InternalResourceViewResolver  resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        
        return resolver;
    }
    
    // 攔截器設定
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // i18n設定 20170525_sam
		registry.addInterceptor(localeInterceptor());
    }
    
    // i18n設定 20170525_sam
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("messages"); // (X)
//        messageSource.setBasename("classpath:messages"); // (O)關鍵: 有加classpath:有很大的差別
        messageSource.setBasename("/WEB-INF/i18n/messages"); // (O)關鍵: 路徑的判斷須根據 Properties->Resource->Deployment Assembly中的設定來決定
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return messageSource;
    }
    
    // i18n設定 20170525_sam
    @Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        localeResolver.setCookieName("my-locale-cookie");
        localeResolver.setCookieMaxAge(0);
        return localeResolver;
    }
    
    // i18n設定 20170525_sam
    @Bean
    public LocaleChangeInterceptor localeInterceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }
	
}