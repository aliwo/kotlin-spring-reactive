package com.example.kotlinr2dbc.controllers

import com.example.kotlinr2dbc.services.RestaurantService
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RestaurantControllerTest(
    private val restaurantService: RestaurantService,
): BehaviorSpec({
    given("레스토랑 2개 조회") {
        `when`("레스토랑 2개 조회") {
            val restaurants = restaurantService.getTwoRestaurants()
            then("레스토랑 2개 조회") {
                restaurants
                restaurants.size.shouldBe(2)
            }
        }
    }
})