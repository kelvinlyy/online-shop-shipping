package com.example.onlineshopshipping.controller

import com.example.onlineshopshipping.controller.ShippingControllerImpl.Companion.BASE_SHIPPING_URL
import com.example.onlineshopshipping.service.ShippingService
import com.fasterxml.jackson.databind.ObjectMapper
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.put


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class OrderControllerImplTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper
) {
    @RelaxedMockK
    lateinit var shippingService: ShippingService
    
    @Test
    fun `should start an order shipping`() {
        // when/then
        mockMvc.post("$BASE_SHIPPING_URL/1") {
            contentType = MediaType.APPLICATION_JSON
        }
            .andDo { print() }
            .andExpect {
                status { isCreated() }
            }
            .andReturn()
    }

    @Test
    fun `should finish an order shipping`() {
        // when/then
        mockMvc.put("$BASE_SHIPPING_URL/1") {
            contentType = MediaType.APPLICATION_JSON
        }
            .andDo { print() }
            .andExpect {
                status { isNoContent() }
            }
            .andReturn()

    }
}