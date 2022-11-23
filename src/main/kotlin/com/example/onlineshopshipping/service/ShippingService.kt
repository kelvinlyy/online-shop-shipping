package com.example.onlineshopshipping.service


interface ShippingService {
    fun startShipping(orderId: Long)
    fun finishShipping(orderId: Long)
}