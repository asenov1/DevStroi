package guru.springframework.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll();

        httpSecurity.csrf().disable();
        httpSecurity.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/login/**").hasRole("ADMIN");

    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password")).roles("USER");
        //.password("dancho123")
        //.authorities("ROLE_USER");
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
//
//    protected void configure(HttpSecurity http) throws  Exception {
//        http
//
//
//                .csrf().disable()
//                .authorizeRequests();
//                .antMatchers(ENABLE_ADDRESSES).permitAll()
//                .antMatchers(ENABLE_RESOURCES).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/administrator").permitAll()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/index")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/administrator").permitAll()
//                .and();
//
//    }



//
//                .csrf().disable()
//                .authorizeRequests()
//
//               // .antMatchers("/index", "/header").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/administrator")
//                .failureUrl("/login-error")
//    .permitAll()
//                .and()
//                .logout()
//               .permitAll();
//    }


                //.antMatchers("/admin/**").hasRole("ADMIN")
               // .antMatchers("/anonymous*").anonymous()
                //.antMatchers("/product/administrator*").permitAll()
//                .antMatchers("/","/header").permitAll()
//                .anyRequest().authenticated()
//                .and()
//               .formLogin()
//                .loginPage("/administrator")
//                .permitAll() //administrator fail
//
//                //.defaultSuccessUrl("/header.html", true)
//                .usernameParameter("username")
//                .passwordParameter("passwordname")
//                .defaultSuccessUrl("/products")
//                .and()
//                .logout()
//                .permitAll();
               //.loginPage("/administrator.html");
        //http.authorizeRequests()
                //.antMatchers("/admin/**").hasRole("ADMIN")
                //.antMatchers("anonymous*").anonymous()
               // .antMatchers("/login*").permitAll()
                //.anyRequest().authenticated()
                //.and()
                //.formLogin()
                //.loginPage("/administrator.html")

               //  .and()
               // .logout()
               // .logoutSuccessUrl("/index.html");




//}
//}

