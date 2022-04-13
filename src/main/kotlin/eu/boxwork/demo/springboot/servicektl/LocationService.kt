package eu.boxwork.demo.springboot.servicektl

import com.fasterxml.jackson.databind.ObjectMapper
import eu.boxwork.demo.springboot.dto.LocationDto
import eu.boxwork.demo.springboot.dto.RatingDto
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.util.ArrayList
import java.util.function.Consumer

@Component
class LocationService {
    val mapper = ObjectMapper()

    /**
     * gibt die Locations als Zeichenketten zurück
     * @return die Liste der Locations wird zurückgegeben oder eine leere List
     * @throws IOException: wenn eine Datei nicht gelesen werden kann
     */
    fun readContent(folder: String): List<String>
    {
        // definieren eine leere Liste als Rückgabewert
        val fileContent: MutableList<String> = ArrayList()
        // wurzelverzeichnis in dem die Dateien liegen...
        val root = File(folder)
        // ... lesen der vorhandenen Dateien...
        val locationFiles = root.list()

        if (locationFiles==null) return fileContent

        // ... wenn nix da ist, geben wir die leere Liste zurück
        // ansonsten, lesen wir in der FOR-Schleife jede Datei ein...
        for (locationFile in locationFiles) {
            // hier lesen wir den Inhalt der Datei
            val filename = root.absolutePath +File.separator+ locationFile
            val content = Files.readString(File(filename).toPath())
            fileContent.add(content)
        }
        //... die wir dann zurück geben :) FERTIG
        return fileContent
    }

    /**
     * gibt die Locations als Zeichenketten zurück
     * @return die Liste der Locations wird zurückgegeben oder eine leere List
     * @throws IOException: wenn eine Datei nicht gelesen werden kann
     */
    @Throws(IOException::class)
    fun getLocations(): List<LocationDto> {
        // definieren eine leere Liste als Rückgabewert
        val fileContent: MutableList<LocationDto> = ArrayList()
        // lese inhalt als Strings
        readContent("src/main/resources/static/data/").forEach(Consumer { t ->
            fileContent.add( mapper.readValue(t, LocationDto::class.java) )
        })
        return fileContent
    }

    fun getRatings(): List<RatingDto> {
        // definieren eine leere Liste als Rückgabewert
        val fileContent: MutableList<RatingDto> = ArrayList()
        // lese inhalt als Strings
        readContent("src/main/resources/static/data/").forEach(Consumer { t ->
            fileContent.add( mapper.readValue(t, RatingDto::class.java) )
        })
        return fileContent
    }
}