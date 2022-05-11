package com.g9.handbagstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.HttpStatusRequestRejectedHandler;
import org.springframework.security.web.firewall.RequestRejectedHandler;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class MySpringSecurityConfig {
	@Configuration
	@Order(1)
	public static class UserSecurityConfig extends WebSecurityConfigurerAdapter{
		@Autowired
		private UserDetailsService detailsService;

		public UserSecurityConfig(){
			super();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(detailsService);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.antMatchers("/static/**").permitAll();

			http.authorizeRequests()
					.antMatchers("/products/product/add_to_cart/**").hasRole("USER")
					.antMatchers("/cart/**").hasRole("USER")
					.and().formLogin()
						.loginPage("/login")
						.loginProcessingUrl("/authenUser")
						.usernameParameter("email")
						.passwordParameter("password")
						.defaultSuccessUrl("/")
					.and().logout()
						.logoutUrl("/pa/logout")
						.logoutSuccessUrl("/")
						.deleteCookies("JSESSIONID")
						.permitAll()
					.and().cors()
					.and().csrf().disable();

		}
	}

	@Configuration
	@Order(2)
	public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter{
		@Autowired
		private UserDetailsService detailsService;

		public AdminSecurityConfig(){
			super();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(detailsService);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.antMatchers("/static/**").permitAll();

			http.authorizeRequests()
					.antMatchers("/admin/**").hasRole("ADMIN")
							.and().formLogin()
								.loginPage("/admin/login")
										.loginProcessingUrl("/authenAdmin")
					.usernameParameter("username")
					.passwordParameter("password")
												.defaultSuccessUrl("/admin/welcome")
					.and().cors()
					.and().csrf().disable();


//			http.authorizeRequests()
//					.antMatchers("/admin/**").hasRole("ADMIN")
//					.and().formLogin()
//					.loginPage("/admin/login")
//					.loginProcessingUrl("/admin/authenAdmin")
//					.usernameParameter("email")
//					.passwordParameter("password")
//					.defaultSuccessUrl("/admin/welcome")
//					.permitAll()
//					.and().logout()
//					.logoutUrl("/admin/logout")
//					.logoutSuccessUrl("/admin/login")
//					.deleteCookies("JSESSIONID")
//					.permitAll()
//					.and().cors()
//					.and().csrf().disable();

		}
	}


	@Bean
	public HttpFirewall configureFirewall(){
		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
		strictHttpFirewall.setAllowUrlEncodedSlash(true);

		return strictHttpFirewall;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}