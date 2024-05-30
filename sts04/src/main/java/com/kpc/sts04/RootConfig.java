package com.kpc.sts04;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class RootConfig {
	
//<bean id="dataSource"
// class="org.springframework.jdbc.datasource.DriverManagerDataSource"
// p:driverClassName="org.h2.Driver" 
// p:url="jdbc:h2:tcp://localhost/~/test" 
// p:username="sa" 
// p:password=""
// />
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = null;
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	
//<bean id="jdbcTemplate"
// class="org.springframework.jdbc.core.JdbcTemplate"
// p:dataSource-ref="dataSource"/>
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
}
















