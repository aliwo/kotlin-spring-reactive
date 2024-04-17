package com.example.kotlinr2dbc.controllers

import Address
import Grade
import Restaurant
import com.example.kotlinr2dbc.repositories.MongoRepository
import io.kotest.core.spec.style.BehaviorSpec
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.LocalDateTime
import kotlin.random.Random


@SpringBootTest
@AutoConfigureWebTestClient
class RestaurantControllerTest(
    @Autowired private val webTestClient: WebTestClient,
    private val mongoRepository: MongoRepository,
): BehaviorSpec({
    given("레스토랑 2개 조회") {
        mongoRepository.insertOne(
            Restaurant(
                id = ObjectId(),
                address = Address(
                    building = "Building", street = "street", zipcode = "zipcode", coord =
                    listOf(Random.nextDouble(), Random.nextDouble())
                ),
                borough = "borough",
                cuisine = "cuisine",
                grades = listOf(
                    Grade(
                        date = LocalDateTime.now(),
                        grade = "A",
                        score = Random.nextInt()
                    )
                ),
                name = "name",
                restaurantId = "restaurantId"
            )
        )
        `when`("레스토랑 조회") {
            then("레스토랑 조회") {
                webTestClient.get().uri("/restaurants").exchange()
                    .expectStatus().isOk
                    .expectBody()
                    .jsonPath("$[0].borough").isEqualTo("borough")
            }
        }
    }
})