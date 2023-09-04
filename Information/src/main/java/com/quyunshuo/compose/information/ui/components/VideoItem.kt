package com.quyunshuo.compose.information.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quyunshuo.compose.information.model.VideoEntity

@Composable
fun VideoItem(videoEntity: VideoEntity) {

}

@Preview
@Composable
fun VideoItemPreview() {
    val videoEntity = VideoEntity(
        title = "行测老师告诉你如何制定适合自己的学习方案",
        type = "视频课程",
        duration = "00:02:00",
        imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
    )
    VideoItem(videoEntity)
}