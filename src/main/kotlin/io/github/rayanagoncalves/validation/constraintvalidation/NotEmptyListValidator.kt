package io.github.rayanagoncalves.validation.constraintvalidation

import io.github.rayanagoncalves.rest.dto.OrderItemDTO
import io.github.rayanagoncalves.validation.NotEmptyList
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NotEmptyListValidator: ConstraintValidator<NotEmptyList, List<OrderItemDTO>> {

    override fun isValid(list: List<OrderItemDTO>?, p1: ConstraintValidatorContext?): Boolean {
       return list != null && list.isNotEmpty()
    }
}