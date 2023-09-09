package com.quyunshuo.compose.information.ui.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.quyunshuo.compose.information.model.VideoEntity

/**
 * 该 composable 使用约束布局来实现
 *
 * @param videoEntity VideoEntity 视频 item 数据实体
 */
@Composable
fun VideoItem(videoEntity: VideoEntity) {

    /**
     * 约束集
     */
    val constraintSet = ConstraintSet {
        val videoCover = createRefFor("id_video_cover")
        val videoPlay = createRefFor("id_video_play")
        val type = createRefFor("id_type")
        val duration = createRefFor("id_duration")
        val title = createRefFor("id_title")

        constrain(videoCover) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        }

        constrain(videoPlay) {
            centerTo(videoCover)
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        }

        constrain(type) {
            bottom.linkTo(videoCover.bottom)
            start.linkTo(videoCover.end)
        }

        constrain(duration) {
            end.linkTo(parent.end)
            bottom.linkTo(videoCover.bottom)
        }

        constrain(title) {
            top.linkTo(videoCover.top)
            start.linkTo(videoCover.end)
            end.linkTo(parent.end)
            bottom.linkTo(type.top)
            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        }
    }

    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 8.dp)
    ) {
        AsyncImage(
            model = videoEntity.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId("id_video_cover")
                .padding(start = 8.dp)
                .aspectRatio(16 / 9f)
                .fillMaxHeight()
                .clip(RoundedCornerShape(8.dp))

        )

        Icon(
            imageVector = Icons.Default.PlayCircleOutline,
            tint = Color.White,
            contentDescription = "play",
            modifier = Modifier
                .layoutId("id_video_play")
                .height(35.dp)
                .aspectRatio(1 / 1f)
        )

        Text(
            text = "视频课件",
            fontSize = 10.sp,
            color = Color(0xFF999999),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId("id_type")
                .padding(start = 5.dp)
        )

        Text(
            text = "时长:${videoEntity.duration}",
            fontSize = 10.sp,
            color = Color(0xFF999999),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId("id_duration")
                .padding(end = 8.dp)
        )

        Text(
            text = videoEntity.title,
            fontSize = 16.sp,
            color = Color(0xFF666666),
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .layoutId("id_title")
                .padding(bottom = 8.dp)
                .padding(horizontal = 8.dp)
        )
    }

    Divider(
        modifier = Modifier.layoutId("id_divider")
    )
}

@Preview(showBackground = true)
@Composable
fun VideoItemPreview() {
    val videoEntity = VideoEntity(
        title = "行测老师告诉你如何制定适合自己的学习方案行测老师告诉你如何制定适合自己的学习方案行测老师告诉你如何制定适合自己的学习方案行测老师告诉你如何制定适合自己的学习方案",
        type = "视频课程",
        duration = "00:02:00",
        imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
    )
    VideoItem(videoEntity)
}