package com.preslavrachev.sccdemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigServer
class ConfigServerApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(ConfigServerApplication::class.java, *args)
}
