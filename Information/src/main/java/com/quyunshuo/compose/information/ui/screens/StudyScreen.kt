package com.quyunshuo.compose.information.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.quyunshuo.compose.information.MainVM
import com.quyunshuo.compose.information.ui.components.ArticleItem
import com.quyunshuo.compose.information.ui.components.Banner
import com.quyunshuo.compose.information.ui.components.NotificationContent
import com.quyunshuo.compose.information.ui.components.TopAppBar
import com.quyunshuo.compose.information.ui.components.VideoItem

@Composable
fun StudyScreen(vm: MainVM = viewModel()) {

    Column(modifier = Modifier.background(Color.White)) {

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

        /**
         * Tab 栏，使用 material3 中的 ScrollableTabRow，这是一个可滑动的 tab 栏
         */
        ScrollableTabRow(
            selectedTabIndex = vm.categoryIndex,
            containerColor = Color(0x22149EE7),
            edgePadding = 0.dp,
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(it[vm.categoryIndex]),
                    color = Color(0xFF149EE7)
                )
            }
        ) {
            vm.categories.forEachIndexed { index, category ->
                Tab(
                    selected = vm.categoryIndex == index,
                    // 点击时更新 ViewModel 中关于当前所选下标的 state
                    // 但我们应该过滤相同的下标点击事件，这部分逻辑写在 ViewModel 中了
                    onClick = { vm.updateCategoryIndex(index) },
                    text = {
                        Text(
                            text = category.title,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontSize = 14.sp
                        )
                    },
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666),
                    modifier = Modifier
                        .height(50.dp)
                        .wrapContentWidth()
                )
            }
        }

        /**
         * 内容分类
         */
        TabRow(
            selectedTabIndex = vm.currentTypeIndex,
            containerColor = Color.Transparent,
            indicator = {},
            divider = {}
        ) {
            vm.types.forEachIndexed { index, dataType ->
                LeadingIconTab(
                    selected = vm.currentTypeIndex == index,
                    onClick = { vm.updateTypeIndex(index) },
                    icon = {
                        Icon(imageVector = dataType.icon, contentDescription = null)
                    },
                    text = {
                        Text(
                            text = dataType.title,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontSize = 14.sp
                        )
                    },
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666),
                    modifier = Modifier
                        .height(50.dp)
                        .wrapContentWidth()
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            LazyColumn() {

                item {
                    /**
                     * 轮播图
                     */
                    Banner(vm.bannerState)
                }

                item {
                    /**
                     * 通知公告
                     */
                    NotificationContent(vm.notificationList)
                }
                /**
                 * 根据是否显示资讯文章来控制显示的列表内容
                 */
                if (vm.showArticleList) {
                    items(vm.articleList) { articleEntity ->
                        ArticleItem(article = articleEntity)
                    }
                } else {
                    items(vm.videoList) { videoEntity ->
                        VideoItem(videoEntity)
                    }
                }
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, device = "id:pixel_2_xl")
@Composable
fun StudyScreenPreview() {
    StudyScreen()
}