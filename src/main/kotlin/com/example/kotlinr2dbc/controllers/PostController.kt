package com.example.kotlinr2dbc.controllers

import com.example.kotlinr2dbc.services.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    private val postService: PostService,
) {

    @GetMapping
    suspend fun getPosts() = postService.getPosts()
}
