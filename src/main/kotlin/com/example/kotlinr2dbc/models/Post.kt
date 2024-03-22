package com.example.kotlinr2dbc.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("posts")
data class Post(
    @Id val id: Long? = null,
    @Column("title") val title: String? = null,
    @Column("content") val content: String? = null,
)
