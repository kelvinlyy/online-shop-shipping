package com.example.onlineshopshipping.controller

import org.springframework.http.ResponseEntity


interface ShippingController {
    fun startShipping(orderId: Long): ResponseEntity<Unit>
    fun finishShipping(orderId: Long): ResponseEntity<Unit>
}