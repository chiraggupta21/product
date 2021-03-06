package com.grizzly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	PasswordEncoder passwordEncoder;	
	
	@Autowired
	private ProductAuthenticateSuccessHandler sh;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user").password(passwordEncoder
       .encode("ho")).roles("USER").and().withUser("admin").password(passwordEncoder.encode("he")).roles("USER","ADMIN");	
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/products").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/**").hasAnyRole("ADMIN","USER")
		.and().formLogin().loginPage("/login").successHandler(sh)
		.and().logout().logoutSuccessUrl("/login").permitAll()
		.and().csrf().disable();
	}
}
