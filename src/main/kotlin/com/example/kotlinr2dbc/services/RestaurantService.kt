package com.example.kotlinr2dbc.services

import Restaurant
import com.example.kotlinr2dbc.repositories.MongoRepository
import org.springframework.stereotype.Service

@Service
class RestaurantService(
    private val mongoRepository: MongoRepository,
) {
    suspend fun getTwoRestaurants(): List<Restaurant> {
        return mongoRepository.getAllWithLimit(2)
    }
}
