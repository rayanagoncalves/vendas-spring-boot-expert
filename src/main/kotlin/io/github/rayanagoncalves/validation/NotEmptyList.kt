package io.github.rayanagoncalves.validation

import io.github.rayanagoncalves.validation.constraintvalidation.NotEmptyListValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [NotEmptyListValidator::class])
annotation class NotEmptyList(
    val message: String = "A lista não pode ser vazia.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)