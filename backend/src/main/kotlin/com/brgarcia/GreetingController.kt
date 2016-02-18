package com.brgarcia

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class GreetingController @Autowired constructor(val greetingRepository: GreetingRepository) {

    @RequestMapping("/greeting", method = arrayOf(RequestMethod.GET))
    fun greeting() =
            greetingRepository.all()


    @RequestMapping(value = "/greeting", method = arrayOf(RequestMethod.POST))
    fun greeting(@Valid @RequestBody greeting: Greeting) =
            greetingRepository.include(greeting)
}