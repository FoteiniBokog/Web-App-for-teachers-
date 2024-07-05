package com.project.ProjectApp_4315_4438.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/*
 * @Configuration Indicates that a class declares one or more 
 * @Bean methods and may be processed by the 
 * Spring container to generate bean definitions 
 * and service requests for those beans at runtime. 
 * The class may also have code that configures other 
 * spring functionalities. 
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	/*@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/*").hasAnyRole("USER","ADMIN")
		.antMatchers("/login*").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin();

		
	}*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		// bcrypt online https://bcrypt-generator.com/
		
		// password "john" is externally encrypted to the following password zaras123
		UserDetails user = User.withUsername("zaras")
			     .password("$2a$12$npEfL2uYjS3dfRj9x4udYujYqoJBGthGYZr5Ju0NcFXlUKNip9pB2")
			     .roles("STUDENT","ADMIN")
			     .build();
		
		
		auth.inMemoryAuthentication().withUser(user);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}