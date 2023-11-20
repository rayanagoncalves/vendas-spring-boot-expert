package io.github.rayanagoncalves.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig: WebSecurityConfiguration() {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.
        authorizeHttpRequests()?.
   //     requestMatchers("/topics")?.hasAuthority("READ_WRITE")?.
        anyRequest()?.
        authenticated()?.
        and()?.
        sessionManagement()?.
        sessionCreationPolicy(SessionCreationPolicy.STATELESS)?.
        and()?.
        formLogin()?.disable()?.
        httpBasic()

        return http.build()
    }
}