package eu.boxwork.demo.springboot.servicektl

import eu.boxwork.demo.springboot.dto.PageDataDto
import eu.boxwork.demo.springboot.dto.TableHeaderDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class ViewControler (
    @Autowired var service: LocationService
        ){
    @RequestMapping(value = ["/","/index.html"]) fun index() = "index"
    @RequestMapping(value = ["/index2"]) fun index2() = "index2" // this does not exists !

    @RequestMapping(value = ["/locations"])
    fun locations(): ModelAndView {
        val mv = ModelAndView("locations")

        // some static content
        val pageDataDto = PageDataDto("locations","this page lists the best locations ever.")
        mv.addObject(pageDataDto)

        // table header, here static, could be a language map
        val tableHeaderDto = TableHeaderDto("name","rating","groups")
        mv.addObject(tableHeaderDto)

        val ratings = service.getRatings()
        mv.addObject(ratings)

        return mv
    }
}