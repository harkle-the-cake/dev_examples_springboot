package eu.boxwork.demo.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("eu.boxwork.demo.springboot.servicektl")
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
