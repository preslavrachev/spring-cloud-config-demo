package com.preslavrachev.sccdemo

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@EnableAutoConfiguration
@SpringBootApplication
@RestController
@RequestMapping("/")
class ClientApplication {

    @Value("\${config.answer}")
    private var theAnswer: Int = 0

    @Value("\${config.secret.answer}")
    private var theSecretAnswer: Int = 0

    @GetMapping("/theAnswer")
    fun theAnswer(): Int {
        return theAnswer
    }

    @GetMapping("/theSecretAnswer")
    fun theSecretAnswer(): Int {
        return theSecretAnswer
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(ClientApplication::class.java, *args)
}
