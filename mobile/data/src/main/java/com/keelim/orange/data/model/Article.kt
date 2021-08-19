package com.keelim.orange.data.model


data class Article(
    var articleContent: String,
    var articleId: Int,
    var articleWritetime: String,
    var challenge: Int,
    var title: String,
    var user: Int,
    var verified: Boolean,
    var articleImage: String,
)