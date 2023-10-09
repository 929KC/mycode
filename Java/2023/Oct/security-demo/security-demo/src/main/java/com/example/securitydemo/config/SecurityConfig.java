package com.example.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码需要设置编码器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        //2.使用JDBC进行身份认证
        String userSQL ="select username,password,valid from t_customer "+ "where username = ?";
        String authoritySQL="select c.username,a.authority from t_customer c, "+"t_authority 	a,t_customer_authority ca where "+"ca.customer_id=c.id and ca.authority_id=a.id and c.username =?";
        auth.jdbcAuthentication().passwordEncoder(encoder).dataSource(dataSource)
                .usersByUsernameQuery(userSQL).authoritiesByUsernameQuery(authoritySQL);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/detail/common/**").hasRole("common")
                .antMatchers("/detail/vip/**").hasRole("vip")
                .anyRequest().authenticated();

            //自定义用户登录控制
        http.formLogin()
                      .loginPage("/userLogin").permitAll()
                      .usernameParameter("name").passwordParameter("pwd")
                      .defaultSuccessUrl("/")
                      .failureUrl("/userLogin?error");

              //自定义用户退出
        http.logout()
                    .logoutUrl("/mylogout")
                    .logoutSuccessUrl("/userLogin");


            //记住我
        http.rememberMe()
                .rememberMeParameter("rememberme")
                .tokenValiditySeconds(200)
                //对Cookie信息进行持久化管理
                .tokenRepository(tokenRepository());

    }
    @Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl jr=new JdbcTokenRepositoryImpl();
        jr.setDataSource(dataSource);
        return jr;}

}
