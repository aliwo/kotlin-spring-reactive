package com.example.kotlinr2dbc.controllers
import com.example.kotlinr2dbc.services.PostService
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeIn
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PostControllerTest(
    private val postService: PostService,
) : BehaviorSpec({

    given("포스트 생성하고 get posts") {
        val post = postService.createPost("title", "content")
        `when`("get posts") {
            val posts = postService.getPosts()
            then("방금 생성한 post 가 들어가 있다.") {
                post shouldBeIn posts
            }
        }
    }
})
