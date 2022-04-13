package eu.boxwork.demo.springboot.servicektl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RatingServiceController(
    @Autowired var service: LocationService
) {

    @GetMapping("/rating")
    fun getRatings() = service.getRatings()
}