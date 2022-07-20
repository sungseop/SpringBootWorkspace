package com.ezen.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ezen.jdbc.util.JDBCConnectionManager;

@Configuration
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {

	@Autowired
	private JDBCConnectionManagerProperties prop;
	
	@Bean
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJDBCconnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		
		manager.setDriverClass(prop.getDriverClass());
		manager.setUrl(prop.getUrl());
		manager.setUsername(prop.getUsername());
		manager.setPassword(prop.getPassword());
		/*
		manager.setDriverClass("org.h2.Driver");
		manager.setUrl("jdbc:h2:tcp://211.252.154.253/~/test");
		manager.setUsername("sa");
		manager.setPassword("");
		*/
		return manager;
	}
}
