package com.example.kotlinr2dbc.controllers

import com.example.kotlinr2dbc.services.RestaurantService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restaurants")
class RestaurantController(
    private val restaurantService: RestaurantService,
) {
    @GetMapping
    suspend fun getPosts() = restaurantService.getTwoRestaurants()
}
