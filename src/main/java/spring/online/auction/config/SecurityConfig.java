package spring.online.auction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auction/phone/**").permitAll()
                .antMatchers("/auction/bid/**").permitAll()
                .antMatchers("/auction/user/all/**").permitAll()
                .antMatchers("/auction/user/user/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/auction/user/admin/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and().logout().and().formLogin();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select login, password, is_active from a_user where login=? " +
                        "and is_active=true")
                .authoritiesByUsernameQuery("select u.login, ur.role_name as role " +
                        "from user_role ur inner join a_user u on ur.user_id = u.id where u.login=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

