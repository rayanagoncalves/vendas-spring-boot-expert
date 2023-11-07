package io.github.rayanagoncalves.rest.controller

import io.github.rayanagoncalves.exception.BusinessRuleException
import io.github.rayanagoncalves.rest.ApiErrors
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApplicationControllerAdvice {

    @ExceptionHandler(BusinessRuleException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBusinessRuleException(ex: BusinessRuleException): ApiErrors {
        val errorMessage = ex.message
        return ApiErrors(errorMessage!!)
    }
}