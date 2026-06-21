package com.mahesh.HireHub.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.mahesh.HireHub.Service.CustomeRecuterDetailsService;
import com.mahesh.HireHub.Service.CustomeUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomeRecuterDetailsService cr;
	
	@Autowired
	private CustomeUserDetailsService cu;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
        .csrf(csrf -> csrf.disable())
        .authenticationProvider(authenticationProviderForUser(cu))
        .authenticationProvider(authenticationProviderForRecuters(cr))
        .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/api/auth/register",
                        "/api/recruiter/register"
                ).permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/recruiter/**").hasRole("RECRUITER")
                .requestMatchers("/api/user/**").hasRole("USER")
                .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());

    return http.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProviderForUser(CustomeUserDetailsService userDetailsService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
	@Bean
	public AuthenticationProvider authenticationProviderForRecuters(CustomeRecuterDetailsService recuterDetailsService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(recuterDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}


}
