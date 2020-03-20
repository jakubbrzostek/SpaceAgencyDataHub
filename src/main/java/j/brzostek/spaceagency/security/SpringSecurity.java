package j.brzostek.spaceagency.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService () {
        UserDetails contentManager = User.withDefaultPasswordEncoder() //demo purpose only :)
                .username("Content Manager")
                .password("manager1")
                .roles("CONTENT MANAGER")
                .build();

        UserDetails customer = User.withDefaultPasswordEncoder()
                .username("Customer")
                .password("customer1")
                .roles("CUSTOMER")
                .build();

        return  new InMemoryUserDetailsManager(contentManager, customer);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/missions").hasRole("CONTENT MANAGER")
                .antMatchers(HttpMethod.GET,"/api/products").hasRole("CONTENT MANAGER")
                .antMatchers(HttpMethod.GET,"/api/products").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.POST,"/api").hasRole("CONTENT MANAGER")
                .antMatchers(HttpMethod.DELETE,"/api").hasRole("CONTENT MANAGER")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable(); //to allow f. e. Postman checks
    }

}
