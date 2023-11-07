package io.github.rayanagoncalves.exception

class BusinessRuleException(override val message: String): RuntimeException(message = message)