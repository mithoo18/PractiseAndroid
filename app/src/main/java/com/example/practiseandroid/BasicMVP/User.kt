package com.example.practiseandroid.BasicMVP

data class User(
    val fullName : String ="", val email : String =""){
    override fun toString(): String {
        return """
            $fullName
            $email
            """.trimIndent()
    }
}