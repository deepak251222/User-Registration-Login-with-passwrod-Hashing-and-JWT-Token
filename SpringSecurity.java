package com.main.secrity;

import org.aspectj.weaver.ast.And;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SpringSecurity {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() throws Exception {

		UserDetails deepak = User.builder().username("deepak")
				.password(passwordEncoder().encode("deepak123"))
				.roles("USER").build();
		
////		UserDetails mukesh=User.builder()
////				  .username("deepak")
////				  .password("{noop}deepak123")
////				  .roles("MANAGER")
////				  .build();
//
////		UserDetails deepak=User.builder()
////				  .username("deepak")
////				  .password("{noop}deepak123")
////				  .roles("USER","MANAGER","ADMIN")
////				  .build();
//
		return new InMemoryUserDetailsManager(deepak);
//
	}
//
//
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////		 http.authorizeRequests()
////         .requestMatchers("/web/**")
////         .permitAll()
////         .and()
////         .authorizeRequests()
////      .requestMatchers(HttpMethod.POST, "/web/***")
////        //.requestMatchers("/web/**")
////        .permitAll()
////      // .hasRole("USER")
////         .anyRequest()
////         .authenticated()
////         .and()
////         .httpBasic();
////     return http.build();
////	}
		http.authorizeHttpRequests(Configuration -> Configuration
 				.requestMatchers(HttpMethod.GET, "/api/user").hasRole("USER")
				.requestMatchers(HttpMethod.GET, "/api/user/**").hasRole("USER")
				.requestMatchers(HttpMethod.POST, "/api/user").hasRole("USER")
				.requestMatchers(HttpMethod.POST, "/api/token").hasRole("USER")
				.requestMatchers(HttpMethod.POST, "/api/login").hasRole("USER")
				
				.requestMatchers("/**").permitAll()
				// **** WEB Page ****
//				.requestMatchers(HttpMethod.GET, "/web/welcome").hasRole("USER")
//				.requestMatchers(HttpMethod.GET, "/web/adduser").hasRole("USER")
//				.requestMatchers(HttpMethod.GET, "/web/adduser/add").hasRole("USER")
//				.requestMatchers(HttpMethod.POST, "/web/add").hasRole("USER")
//				.requestMatchers(HttpMethod.GET, "/web/search").hasRole("USER")
//				.requestMatchers(HttpMethod.GET, "/web/search").hasRole("USER")
//				.requestMatchers(HttpMethod.GET, "/web/search").hasRole("USER")
		);
		http.httpBasic();
     	http.csrf().disable();
		return http.build();
	}

}
