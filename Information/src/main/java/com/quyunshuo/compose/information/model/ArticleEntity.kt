package com.quyunshuo.compose.information.model

data class ArticleEntity(
    val title: String,
    var source: String,
    var timestamp: String,
    var content: String? = ""
)