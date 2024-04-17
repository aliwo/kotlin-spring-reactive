package com.example.kotlinr2dbc.repositories

import Restaurant
import util.mongoDatabase
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Component

@Component
class MongoRepository {
    companion object {
        val collection = mongoDatabase.getCollection<Restaurant>("restaurants")
    }

    suspend fun getAllWithLimit(limit: Int): List<Restaurant> {
        return collection
            .find<Restaurant>()
            .limit(2)
            .toList()
    }

}