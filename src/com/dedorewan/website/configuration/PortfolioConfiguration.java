package com.dedorewan.website.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableAsync
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.dedorewan.website" })
public class PortfolioConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"classpath:/resources/");
	}

	@Bean
	public WebContentInterceptor webContentInterceptor() {
		WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(0);
		interceptor.setUseExpiresHeader(true);
		;
		interceptor.setUseCacheControlHeader(true);
		interceptor.setUseCacheControlNoStore(true);

		return interceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(webContentInterceptor());
	}
}
