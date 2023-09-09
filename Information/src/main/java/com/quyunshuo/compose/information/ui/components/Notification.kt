package com.quyunshuo.compose.information.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationContent(notificationList: List<String>) {

    // 为了实现无限滚动，设置了虚拟页数和实际页数，具体的数据下标由计算得出
    /**
     * 虚拟页数
     */
    val virtualCount = Int.MAX_VALUE

    /**
     * 实际页数
     */
    val actualCount = notificationList.size

    /**
     * 初始图片下标
     */
    val initialIndex = virtualCount / 2

    val state = rememberPagerState(initialPage = initialIndex) { virtualCount }

    val circulatePlayScope = rememberCoroutineScope()

    /**
     * 启动一个控制循环播放的协程
     * DisposableEffect 可以感知 Composable 的 onActive 和 onDispose，允许通过副作用完成一些预处理和收尾处理
     */
    DisposableEffect(Unit) {
        circulatePlayScope.launch(Dispatchers.Default) {
            delay(1000)
            while (isActive) {
                delay(3000)
                withContext(Dispatchers.Main.immediate) {
                    // 如果在滚动中使用 animateScrollToPage 会导致异常，所以在滚动前需要判断是否在滚动
                    if (!state.isScrollInProgress) {
                        state.animateScrollToPage(state.currentPage + 1)
                    }
                }
            }
        }

        onDispose { circulatePlayScope.cancel() }
    }

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0x22149EE7))
            .height(45.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "最新活动",
            color = Color(0xFF149EE7),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.width(8.dp))

        VerticalPager(
            state = state,
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.Start,
        ) { index ->
            val actualIndex = (index - initialIndex).floorMod(actualCount)

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = notificationList[actualIndex],
                    color = Color(0xFF333333),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "更多",
            color = Color(0xFF666666),
            fontSize = 14.sp,
            maxLines = 1,
        )
    }
}

@Preview
@Composable
fun NotificationContentPreview() {
    val notificationList = listOf(
        "时间会冲淡一切，但它也会让人变得更加坚强。 - 《围城》 金庸",
        "人生就像一本书，每个人都是其中的一章节。 - 《活着》 余华",
        "爱情是一种甜蜜的负担，但它也是生活的动力。 - 《红楼梦》 曹雪芹",
        "命运如同无形的红线，将人们紧密地联系在一起。 - 《平凡的世界》 路遥",
        "人生充满了起起落落，但每一次跌倒都是为了更强大的站起来。 - 《许三观卖血记》 余华",
        "生活中的每个选择都会带来不同的结果，我们要学会承担自己的选择。 - 《活着》 余华",
        "真正的力量来自内心的坚定和勇气，而不是外在的权势和财富。 - 《平凡的世界》 路遥",
        "人生不止眼前的苟且，还有诗和远方。 - 《边城》 沈从文",
        "生活中最珍贵的东西常常被我们忽略，直到失去才会后悔莫及。 - 《红楼梦》 曹雪芹",
        "每个人都有自己的故事，我们应该学会尊重和理解他人的选择和经历。 - 《围城》 金庸"
    )
    NotificationContent(notificationList)
}