package com.example.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	CustomerUsersDetailsService customerUsersDetailsService;

	@Autowired
	JwtFilter jwtFilter;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerUsersDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override // Default Behaviour of HttpSecurityObj will not have any authorization logic
	protected void configure(HttpSecurity authorizationObj) throws Exception {

		authorizationObj.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and()
				.csrf().disable().authorizeRequests().antMatchers("/user/login", "/user/signup", "/user/forgotPassword")
				.permitAll().anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		authorizationObj.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
}*/
