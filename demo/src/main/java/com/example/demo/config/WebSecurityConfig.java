package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-02 12:02
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // @Value("${spring.profiles}")
    // private String env;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").defaultSuccessUrl("/hello").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().authorizeRequests().antMatchers("/**/*.css", "/img/**", "/api/**", "/**/*.js").permitAll();


//        http
//                .authorizeRequests()
////                .antMatchers("/hello").authenticated()
//                .antMatchers("/login").permitAll()
//                .and().authorizeRequests().anyRequest().authenticated();
//                .anyRequest().permitAll();
//        http.formLogin().loginPage("/login").defaultSuccessUrl("/indexDev").permitAll().and()
//                .logout().logoutSuccessUrl("/indexDev")
//                .invalidateHttpSession(true).and().authorizeRequests()
//                .antMatchers("/**/*.css", "/img/**", "/api/**", "/**/*.js") // 放开"/api/**"：为了给被监控端免登录注册
//                .permitAll().and()
//                .rememberMe()
//                .tokenValiditySeconds(36000)//没有什么用
//                .and().authorizeRequests().antMatchers("/**").authenticated();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.httpBasic();
    }

    /*
     * @Autowired // 也可以在application.yml文件中配置登录账号密码：security.user.name/password public void
     * configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
     * auth.inMemoryAuthentication().withUser("whb").password("").roles("USER"); }
     */
}
