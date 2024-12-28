package EncoderSoftware.RoomRental.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class RoomSecurityConfig {
	
	
	@Bean
	InMemoryUserDetailsManager userDetailManager() {

		    UserDetails jhon = User.builder()
		    		.username("jhon")
		    		.password("{noop}john@123")
		    		.roles("EMPLOYEE")
		    		.build();
		    		
		    UserDetails mary = User.builder()
		    		.username("mary")
		    		.password("{noop}mary@123")
		    		.roles("EMPLOYEE","MANAGER")
		    		.build();
		    
		    UserDetails susan = User.builder()
		    		.username("susan")
		    		.password("{noop}susan@123")
		    		.roles("EMPLOYEE","MANAGER","ADMIN")
		    		.build();
		return new InMemoryUserDetailsManager(jhon,mary,susan);
		
	}

	 @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("http://room-rent-app.s3-website.ap-south-1.amazonaws.com"));
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
	        configuration.setAllowCredentials(true);

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	         .cors() // Enable CORS
            .and()
	        .authorizeHttpRequests(configurer -> configurer
	             .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
	             .requestMatchers(HttpMethod.GET, "/api/room/**").permitAll()
	            .requestMatchers(HttpMethod.POST,"/api/room").hasRole("MANAGER") 
	            .requestMatchers(HttpMethod.PUT,"/api/room").hasRole("MANAGER") 
	            .requestMatchers(HttpMethod.DELETE,"/api/room/**").hasRole("ADMIN") 
	            .requestMatchers(HttpMethod.POST, "/api/feedback").permitAll()
	            .requestMatchers(HttpMethod.OPTIONS, "/api/feedback").permitAll()
	            .requestMatchers("/api/feedback").permitAll()
	            .anyRequest().authenticated()
	        );
	     //use http basics authentication
	    http.httpBasic(Customizer.withDefaults());
	    //disable csrf
	    http.csrf(csrf->csrf.disable());
	    return http.build();
	}
	
	


}