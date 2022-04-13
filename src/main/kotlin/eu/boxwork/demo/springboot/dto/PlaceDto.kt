package eu.boxwork.demo.springboot.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PlaceDto (
    @JsonProperty("zip", required = true) val zip: Int,
    @JsonProperty("place", required = true) val place: String
)