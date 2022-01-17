package com.retail.product.productservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * Security Configuration class to enable the security for the REST web service.
 * @author bhava
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    /**
     * Below code will enable the security and permits only below URL format.
     */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		.antMatchers("/").permitAll().and()
		.authorizeRequests().antMatchers("/h2**").permitAll();


		httpSecurity.authorizeRequests() .antMatchers("/").permitAll().and()
		.authorizeRequests().antMatchers("/products/**").permitAll();

		httpSecurity.csrf().disable().authorizeHttpRequests().anyRequest().permitAll();

	}

}
