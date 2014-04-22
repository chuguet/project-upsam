package com.upsam.hospital.controller.config;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.upsam.hospital.model.config.SpringModelConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringControllerConfiguration.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.upsam.hospital.controller")
@Import(SpringModelConfiguration.class)
public class SpringControllerConfiguration {

	/**
	 * Bean que especifica los tipos de petición entre la vista y el
	 * controlador.
	 * 
	 * @return the content negotiating view resolver
	 */
	@Bean
	@Inject
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver(
			MappingJacksonJsonView mappingJacksonJsonView) {
		ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		ArrayList<View> defaultViews = new ArrayList<View>();
		defaultViews.add(mappingJacksonJsonView);
		contentNegotiatingViewResolver.setDefaultViews(defaultViews);
		return contentNegotiatingViewResolver;
	}

	@Bean
	public ContentNegotiationManagerFactoryBean contentNegotiationManager() {
		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager
				.setDefaultContentType(MediaType.APPLICATION_JSON);
		return contentNegotiationManager;
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	/**
	 * Mapping jackson json view.
	 * 
	 * @return the mapping jackson json view
	 */
	@Bean
	public MappingJacksonJsonView mappingJacksonJsonView() {
		return new MappingJacksonJsonView();
	}

	/**
	 * Multipart resolver.
	 * 
	 * @return the commons multipart resolver
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
}
