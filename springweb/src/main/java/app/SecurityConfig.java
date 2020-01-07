package app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Denis").password("{noop}secret").roles("USER").
                and().
                withUser("Denis2").password("{noop}secret").roles("ADMIN");
    }

    /**
     * Basic auth
     */
    /*protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic().
                and().
                authorizeRequests().
                anyRequest().authenticated();
    }*/

    /**
     * Form login
     */
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated();

        http.formLogin().
                loginPage("/login.jsp").
                loginProcessingUrl("/login").
                successForwardUrl("/success.jsp");

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

    }
}
