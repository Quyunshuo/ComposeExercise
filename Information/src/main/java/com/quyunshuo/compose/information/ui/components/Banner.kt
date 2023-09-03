package com.quyunshuo.compose.information.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Banner(bannerImageUriList: List<String>) {

    // 为了实现无限滚动，设置了虚拟页数和实际页数，具体的数据下标由计算得出
    /**
     * 虚拟页数
     */
    val virtualCount = Int.MAX_VALUE

    /**
     * 实际页数
     */
    val actualCount = bannerImageUriList.size

    /**
     * 初始图片下标
     */
    val initialIndex = virtualCount / 2

    val circulatePlayScope = rememberCoroutineScope()

    val state = rememberPagerState(initialPage = initialIndex) { virtualCount }

    /**
     * 启动一个控制循环播放的协程
     * DisposableEffect 可以感知 Composable 的 onActive 和 onDispose，允许通过副作用完成一些预处理和收尾处理
     */
    DisposableEffect(Unit) {
        circulatePlayScope.launch(Dispatchers.Default) {
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

    HorizontalPager(
        state = state,
        pageSpacing = 6.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(12.dp))
    ) { index ->
        val actualIndex = (index - initialIndex).floorMod(actualCount)

        /**
         * 使用 Coil 加载网络图片
         */
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7f / 3f)
                .clip(RoundedCornerShape(12.dp)),
            model = bannerImageUriList[actualIndex],
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}

fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    //将虚拟数据按照实际数据总数分为 N 组
    //当前虚拟下标是在这虚拟数据中的哪一组：虚拟下标floorDiv实际数据总数(虚拟下标/实际数据总数)。向下取整
    //虚拟下标 - (虚拟下标/实际数据总数) * 实际数据总数
    else -> this - floorDiv(other) * other
}

@Preview
@Composable
fun BannerPreview() {
    val uris = listOf(
        "https://images.unsplash.com/photo-1657287490280-8b22b1a1259f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2071&q=80",
        "https://images.unsplash.com/photo-1606592641984-c9a1506d0705?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1932&q=80",
        "https://images.unsplash.com/photo-1585245332774-3dd2b177e7fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2058&q=80",
        "https://images.unsplash.com/photo-1638757937028-eabad8286d45?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1974&q=80",
        "https://images.unsplash.com/photo-1500027359505-e004de7ed703?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2071&q=80",
        "https://images.unsplash.com/photo-1655365225178-b1b4c59cbdb2?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80",
        "https://images.unsplash.com/photo-1548919973-5cef591cdbc9?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80",
        "https://images.unsplash.com/photo-1627484986972-e544190b8abb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2068&q=80"
    )
    Banner(uris)
}