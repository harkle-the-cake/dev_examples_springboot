package eu.boxwork.demo.springboot.servicektl

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ViewControler {
    @RequestMapping(value = ["/index"]) fun index() = "index"
    @RequestMapping(value = ["/index2"]) fun index2() = "index2" // this does not exists !

    @RequestMapping(value = ["/locations"])
    fun locations(): String? {
        return "locations"
    }
}