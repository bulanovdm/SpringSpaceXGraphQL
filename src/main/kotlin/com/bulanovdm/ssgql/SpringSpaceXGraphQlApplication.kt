package com.bulanovdm.ssgql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration::class)
class SpringSpaceXGraphQlApplication

fun main(args: Array<String>) {
	runApplication<SpringSpaceXGraphQlApplication>(*args)
}
