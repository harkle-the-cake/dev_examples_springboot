package eu.boxwork.demo.springboot.servicektl

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ViewControler {
    @RequestMapping(value = ["/index"])
    fun index(): String? {
        return "index"
    }

    @RequestMapping(value = ["/locations"])
    fun locations(): String? {
        return "locations"
    }
}