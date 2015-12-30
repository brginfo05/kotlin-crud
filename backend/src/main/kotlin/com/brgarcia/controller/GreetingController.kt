package com.brgarcia.controller

import com.brgarcia.model.Greeting
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong
import javax.validation.Valid
import kotlin.text.format

@RestController
class GreetingController {
    private val counter = AtomicLong()

    @RequestMapping("/greeting", method = arrayOf(RequestMethod.GET))
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(),
                template.format(name))
    }

    @RequestMapping(value = "/greeting", method = arrayOf(RequestMethod.POST))
    fun greeting(@Valid @RequestBody greeting: Greeting): Unit {
        println(greeting)
    }

    companion object {

        private val template = "Hello, %s!"
    }
}