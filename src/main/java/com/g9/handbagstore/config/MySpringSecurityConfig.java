package com.g9.handbagstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService detailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css_customer/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/fonts/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/static/**").permitAll()
			.antMatchers("/static/**").permitAll();
		
		http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/welcome/**").hasAnyRole("USER", "ADMIN")
			.and().formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/authenUser")
					.usernameParameter("email")
		            .passwordParameter("password")
		            .defaultSuccessUrl("/welcome")
	                .permitAll()
			.and().logout()
					.deleteCookies("JSESSIONID")
					.permitAll()
			.and().cors()
			.and().csrf().disable();
	}


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}