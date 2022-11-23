package com.example.onlineshopshipping

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class OnlineShopShippingApplication

fun main(args: Array<String>) {
	runApplication<OnlineShopShippingApplication>(*args)
}
