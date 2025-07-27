package com.zodiacagefiesta.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.zodiacagefiesta.repository.UserRepository;
import com.zodiacagefiesta.services.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	private UserRepository userRepo;
	
	private LoginSuccessHandler loginSuccessHandler;
	
	WebSecurityConfig(UserRepository userRepo, LoginSuccessHandler loginSuccessHandler) {
		this.userRepo = userRepo;
		this.loginSuccessHandler = loginSuccessHandler;
	}
	
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserService(userRepo);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/css/**");
	}
	
	@Bean
	SecurityFilterChain config(HttpSecurity http) throws Exception {
		http.authenticationProvider(authenticationProvider());
		
		http.authorizeHttpRequests(authHttp -> authHttp.requestMatchers("/", "/home", "/login", "/register", "/logout").permitAll()
											.requestMatchers("/profile").hasAnyRole("ADMIN", "USER")
											.requestMatchers("/admin").hasRole("ADMIN"));
		
		http.formLogin(l -> l.loginPage("/login").successHandler(loginSuccessHandler));
		
		http.logout((logout) -> logout.logoutSuccessUrl("/home")
										.logoutUrl("/logout")
										.invalidateHttpSession(true)
										.deleteCookies("JSESSIONID"));
		
		return http.build();
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**")
				.addResourceLocations("classpath:/static/")
				.setCachePeriod(3900)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());
	}
	
	
}
