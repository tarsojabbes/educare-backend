package com.tarsojabbes.educare.config;

import com.tarsojabbes.educare.security.JWTAuthenticationFilter;
import com.tarsojabbes.educare.security.JWTUtil;
import com.tarsojabbes.educare.services.AlunoDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Aqui é a injeção da INTERFACE do Spring Security
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    // Array de strings com todas as rotas que serão públicas
    private static final String[] PUBLIC_MATCHERS_GET = {
            "/alunos/**",
            "/questoes/**",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Inicia o cors e desativa a proteção a ataques por ser uma aplicação stateless
        http.cors().and().csrf().disable();
        // Permite acesso não-autorizado para os PUBLIC_MATCHERS e de método GET e qualquer outra Req deve ser autenticada
        http.authorizeRequests().antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    // Configuração básica do Cors
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
