package ma.youcode.reservation.securingweb;

import ma.youcode.reservation.Security.CustomUserDetailsService;
import ma.youcode.reservation.Services.UserService;
import ma.youcode.reservation.Services.security.AppAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        security.httpBasic().disable();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(new Http403ForbiddenEntryPoint() {
//                })
//                .and()
//                .authenticationProvider(getProvider())
//                .formLogin()
//                .loginProcessingUrl("/login")
//                .usernameParameter("email")
//                .successHandler(new AuthentificationLoginSuccessHandler())
//                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
//                .invalidateHttpSession(true)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/logout").permitAll()
//                .antMatchers("/new").authenticated()
//                .anyRequest().permitAll();
//    }
//
//    private class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//        @Override
//        public void onAuthenticationSuccess(HttpServletRequest request,
//                                            HttpServletResponse response, Authentication authentication)
//                throws IOException, ServletException {
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
//    }
//
//    private class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
//
//        @Override
//        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
//                                    Authentication authentication) throws IOException, ServletException {
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
//    }
//    @Bean
//    public AuthenticationProvider getProvider() {
//
//        AppAuthProvider provider = new AppAuthProvider();
//        provider.setUserDetailsService(userDetailsService);
//        return provider;
//
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//        authManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

}
