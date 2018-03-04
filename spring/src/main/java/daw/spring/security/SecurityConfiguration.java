package daw.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	
    	//THIS ENABLES H2 CONSOLE BUT DISABLES HTTPS AND SPRING SECURITY
    	/*
    	http.authorizeRequests().antMatchers("/").permitAll().and()
        	.authorizeRequests().antMatchers("/console/**").permitAll();

		http.csrf().disable();
		http.headers().frameOptions().disable();
    	*/
		
		
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/about").permitAll();
        http.authorizeRequests().antMatchers("/contact").permitAll();
        http.authorizeRequests().antMatchers("/index").permitAll();
        http.authorizeRequests().antMatchers("/moviesInfo/**").permitAll();
        http.authorizeRequests().antMatchers("/seriesInfo/**").permitAll();
        http.authorizeRequests().antMatchers("/movies").permitAll();
        http.authorizeRequests().antMatchers("/movieSearch").permitAll();
        http.authorizeRequests().antMatchers("/register").permitAll();
        http.authorizeRequests().antMatchers("/series").permitAll();
        
        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/profile").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/adminMain").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/moviesPage").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/showsPage").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/usersPage").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/messagesPage").hasAnyRole("ADMIN");
        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/profile");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Database authentication provider
        auth.authenticationProvider(authenticationProvider);
    }
}
