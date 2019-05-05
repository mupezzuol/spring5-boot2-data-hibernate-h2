package com.springboot.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {


	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
	}


}
