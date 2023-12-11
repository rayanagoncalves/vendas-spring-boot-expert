//package io.github.rayanagoncalves.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.provisioning.InMemoryUserDetailsManager
//
//
//@Configuration
//@EnableWebSecurity
class SecurityConfig {

//    @Bean
//    fun passwordEncoder(): PasswordEncoder {
//        return BCryptPasswordEncoder()
//    }

//    @Throws(Exception::class)
//    protected fun configure(http: HttpSecurity) {
//        http
//            .authorizeRequests()
//           // .antMatchers("/public/**").permitAll()
//            .anyRequest().authenticated()
//         //   .and()
//        //    .formLogin()
//           // .loginPage("/login")
//        ///    .permitAll()
//          //  .and()
//          //  .logout()
//         //   .permitAll()
//    }

//    @Bean
//    fun userDetailsService(): InMemoryUserDetailsManager? {
//        val user: UserDetails = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("password")
//            .roles("USER")
//            .build()
//        return InMemoryUserDetailsManager(user)
//    }
}