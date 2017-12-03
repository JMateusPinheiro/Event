package app.configuration;

import static app.model.User.PASSWORD_ENCODER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import app.service.SpringUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SpringUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(PASSWORD_ENCODER);
	}

	// Test without js and css in ant Matcher's with httpBasic
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/", "/bootstrap/**", "/img/**", "/css/**", "/login", "/SignUp", "/RequestSignUp")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.logout()
		.logoutSuccessUrl("/");
	}
}