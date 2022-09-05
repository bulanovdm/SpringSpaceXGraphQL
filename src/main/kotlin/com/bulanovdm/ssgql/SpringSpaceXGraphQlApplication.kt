package com.bulanovdm.ssgql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration::class)
class SpringSpaceXGraphQlApplication

fun main(args: Array<String>) {
	runApplication<SpringSpaceXGraphQlApplication>(*args)
}