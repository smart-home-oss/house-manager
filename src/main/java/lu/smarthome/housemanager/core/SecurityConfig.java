package lu.smarthome.housemanager.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String EMPTY_LINE = "*                                 *";
    public static final String FULL_LINE = "***********************************";

    private final SecurityProperties properties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if(properties.isUseJwtAuth()) {
            http
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/favicon.ico").permitAll()
                    .antMatchers("/api").permitAll()
                    .antMatchers("/api/v1.yml").permitAll()
                    .antMatchers("/webjars/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .oauth2ResourceServer().jwt();
        } else {
            log.error(FULL_LINE);
            log.error(EMPTY_LINE);
            log.error("*             WARNING             *");
            log.error("*       SECURITY IS DISABLED      *");
            log.error(EMPTY_LINE);
            log.error("* app.security.use-jwt-auth=false *");
            log.error(EMPTY_LINE);
            log.error(FULL_LINE);

            http
                    .csrf().disable()
                    .authorizeRequests()
                    .anyRequest().permitAll()
            .and()
                    .oauth2ResourceServer().jwt();
        }

    }
}