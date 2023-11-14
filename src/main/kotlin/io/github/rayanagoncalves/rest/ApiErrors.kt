package io.github.rayanagoncalves.rest

class ApiErrors {
    var errors = mutableListOf<String>()

    constructor(errorMessage: String) {
        this.errors = mutableListOf(errorMessage)
    }

    constructor(errors: List<String?>) {
        this.errors = errors as MutableList<String>
    }
}