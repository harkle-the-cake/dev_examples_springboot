package eu.boxwork.demo.springboot.servicektl

import eu.boxwork.demo.springboot.dto.LocationDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class LocationServiceController(
    @Autowired var service: LocationService,
) {


    @GetMapping("/location")
    fun getLocations() = service.getLocations()

    @GetMapping("/location/{id}")
    fun getLocationByID(
        @PathVariable(value = "id") locationID: Int,
    ): ResponseEntity<LocationDto> {
        val locations = service.getLocations()

        for(i in 0 until locations.size)
        {
            val currentLocation = locations[i]
            if (currentLocation.id == locationID)
            {
                return ResponseEntity.ok(currentLocation)
            }
        }
        throw Exception("Eintrag nicht gefunden.")
    }


    @ExceptionHandler(Exception::class)
    fun handleException(ex:Exception) = ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
}