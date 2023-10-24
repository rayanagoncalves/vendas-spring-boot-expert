package io.github.rayanagoncalves

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention()
@Configuration
@Profile("dev")
annotation class Development()
