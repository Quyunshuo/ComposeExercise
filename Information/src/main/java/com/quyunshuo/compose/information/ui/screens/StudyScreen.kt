package com.quyunshuo.compose.information.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quyunshuo.compose.information.ui.components.TopAppBar

@Composable
fun StudyScreen() {

    Column(modifier = Modifier) {

        /**
         * 标题栏
         */
        TopAppBar(modifier = Modifier.padding(horizontal = 8.dp)) {

            /**
             * 搜索框
             * 为了让搜索框能够自适应剩余空间，使用 weight 设置权重
             */
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f),
                color = Color(0x33FFFFFF)
            ) {
                /**
                 * 用于将搜索框内的元素水平排列
                 */
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .size(16.dp)
                    )

                    Text(
                        "搜索感兴趣的资讯或课程",
                        color = Color.White,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "学习\n进度",
                color = Color.White,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                modifier = Modifier.clickable { }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "66%",
                color = Color.White,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "notification",
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun StudyScreenPreview() {
    StudyScreen()
}