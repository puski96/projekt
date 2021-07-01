package ro.allamvizsga.projekt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    AuthorizationServerConfig authorizationServerConfig;

    @Override
    public void configure(ResourceServerSecurityConfigurer config) throws Exception {
        config.tokenServices(authorizationServerConfig.tokenServices());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
//        		anonymous().disable().authorizeRequests()
//        .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
//        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
			        authorizeRequests()
			        .antMatchers("/api/kresztvesz/get/**","/api/tulaj","/hirdetesek.html","/api/**","api/hirdetesek/32","/api/hirdetesek/save","/img/album/Originals/*","/tyukok.html","/api/fajta","/img/tyukfajtak/*","/img/nyulfajtak/*","/nyulak.html","api/hirdetesek","/api/hirdetesek/get","/api/keres","/api/file/all","/js/getrequest.js","/js/postrequest.js","/css/*","/albumok.html","/api/auth/registration","/img/*","/img/album/*", "/index.html","/JS/*","/oauth","/oauth/token","/Login.html","/test.html","/register.html")
			        .permitAll().and()
			    .authorizeRequests()
				    .anyRequest()
			        .authenticated();
        
    }

}
