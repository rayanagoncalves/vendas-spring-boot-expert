package io.github.rayanagoncalves.rest.controller

import io.github.rayanagoncalves.exception.BusinessRuleException
import io.github.rayanagoncalves.exception.OrderNotFoundException
import io.github.rayanagoncalves.rest.ApiErrors
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.stream.Collectors

@RestControllerAdvice
class ApplicationControllerAdvice {

    @ExceptionHandler(BusinessRuleException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBusinessRuleException(ex: BusinessRuleException): ApiErrors {
        val errorMessage = ex.message
        return ApiErrors(errorMessage!!)
    }

    @ExceptionHandler(OrderNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleOrderNotFoundException(ex: OrderNotFoundException): ApiErrors {
        val errorMessage = ex.message
        return ApiErrors(errorMessage!!)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodNotValidException(ex: MethodArgumentNotValidException): ApiErrors {
        val errors = ex.bindingResult.allErrors.stream().map { it.defaultMessage }.collect(Collectors.toList())
        return ApiErrors(errors)
    }
}