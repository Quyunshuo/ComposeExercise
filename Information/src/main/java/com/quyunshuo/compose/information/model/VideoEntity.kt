package com.quyunshuo.compose.information.model

data class VideoEntity(
    val title: String,
    val type: String? = "",
    val duration: String,
    val imageUrl: String,
    val video: String? = "",
    val desc: String? = ""
)