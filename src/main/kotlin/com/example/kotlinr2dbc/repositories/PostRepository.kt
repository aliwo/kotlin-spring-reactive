package com.example.kotlinr2dbc.repositories

import com.example.kotlinr2dbc.models.Post
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface PostRepository : CoroutineCrudRepository<Post, Long> {
    fun findByTitle(title: String): Flow<Post>
}
