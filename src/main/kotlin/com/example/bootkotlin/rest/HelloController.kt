package com.example.bootkotlin.rest

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime

@RestController
class HelloController {

    @GetMapping("/")
    fun hello() = "Hello Spring Boot with Kotlin - ${LocalDateTime.now()}"
}