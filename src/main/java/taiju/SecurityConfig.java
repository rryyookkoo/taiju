package taiju;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                        //.antMatchers("/css/**").permitAll() // 認証不要なパス。なければ書かなくてOK
                .anyRequest().authenticated().and().formLogin()
                .loginPage("/login") // ログインページのURLは /login で
                .permitAll() // 認証不要
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // ログアウトページのパスは/logoutで
                .permitAll(); // 認証不要
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }
}
