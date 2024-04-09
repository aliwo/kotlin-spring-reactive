package com.example.kotlinr2dbc.services

import com.example.kotlinr2dbc.models.Post
import com.example.kotlinr2dbc.repositories.PostRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
) {

    suspend fun createPost(title: String, content: String): Post {
        return postRepository.save(Post(title = title, content = content))
    }

    suspend fun getPosts(): List<Post> {
        return postRepository.findAll().toList()
    }
}
