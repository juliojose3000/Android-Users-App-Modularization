package com.loaizasoftware.domain.models

data class User(
    val id: Int? = null,
    val name: String,
    val age: Int,
    val lastname: String,
    val photoUrl: String,
    val email: String
)