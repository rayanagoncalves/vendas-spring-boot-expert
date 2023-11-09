package io.github.rayanagoncalves.rest.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateOrderStatusDTO(
    @JsonProperty("newStatus")
    val newStatus: String
)