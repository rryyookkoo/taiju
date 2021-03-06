package taiju;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import taiju.service.UserDetailsServiceImpl;


@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/webjars/**").permitAll() // 認証不要なパス。なければ書かなくてOK
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login") // ログインページのURLは /login で
                    .permitAll() // 認証不要
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // ログアウトページのパスは/logoutで
                    .permitAll(); // 認証不要
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }
}
