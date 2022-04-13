package eu.boxwork.demo.springboot.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class LocationDto(
    @JsonProperty("id", required = true) val id: Int,
    @JsonProperty("title", required = true) val title: String,
    @JsonProperty("location", required = false) val location: PlaceDto?
)
