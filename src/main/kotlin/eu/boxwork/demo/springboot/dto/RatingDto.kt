package eu.boxwork.demo.springboot.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class RatingDto(
    @JsonProperty("title", required = true) val title: String,
    @JsonProperty("rating", required = true) val rating: String,
    @JsonProperty("groups", required = true) val groups: List<String>
)
