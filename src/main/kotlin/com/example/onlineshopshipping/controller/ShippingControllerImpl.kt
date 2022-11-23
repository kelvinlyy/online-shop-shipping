package com.example.onlineshopshipping.controller

import com.example.onlineshopshipping.controller.ShippingControllerImpl.Companion.BASE_SHIPPING_URL
import com.example.onlineshopshipping.service.ShippingService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = [BASE_SHIPPING_URL])
class ShippingControllerImpl(private val shippingService: ShippingService) : ShippingController {
    @PostMapping("/{orderId}")
    override fun startShipping(@PathVariable orderId: Long): ResponseEntity<Unit> {
        return ResponseEntity<Unit>(shippingService.startShipping(orderId), HttpStatus.CREATED)
    }

    @PutMapping("/{orderId}")
    override fun finishShipping(@PathVariable orderId: Long): ResponseEntity<Unit> {
        return ResponseEntity<Unit>(shippingService.finishShipping(orderId), HttpStatus.NO_CONTENT)
    }

    companion object {
        const val BASE_SHIPPING_URL = "/api/shipping"
    }
}