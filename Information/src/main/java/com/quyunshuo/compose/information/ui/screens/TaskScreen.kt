package com.quyunshuo.compose.information.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.quyunshuo.compose.information.TaskVM
import com.quyunshuo.compose.information.ui.components.ArcProgressBar
import com.quyunshuo.compose.information.ui.components.ChartView
import com.quyunshuo.compose.information.ui.components.DailyTaskContent
import com.quyunshuo.compose.information.ui.components.appBarHeight

@Composable
fun TaskScreen(vm: TaskVM = viewModel()) {

    // 圆环高度
    var boxWidthDp: Int
    with(LocalConfiguration.current) {
        boxWidthDp = screenWidthDp / 2
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF149EE7), Color.White)
                )
            )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .statusBarsPadding()
                .height(appBarHeight)
        ) {
            Text(
                text = "学习任务",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }

        LazyColumn {
            /**
             * 学习周期
             */
            item {
                Text(
                    text = vm.taskDateState,
                    fontSize = 12.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            /**
             * 学习进度
             */
            item {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(boxWidthDp.dp)
                        .padding(top = 15.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ) {
                        // 圆弧进度条
                        ArcProgressBar(size = boxWidthDp.dp, progress = vm.pointsProgress)
                    }

                    /**
                     * 积分数据
                     */
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.offset(y = (-5).dp)
                    ) {
                        Text(
                            buildAnnotatedString {
                                append(vm.pointOfYear.toString())
                                withStyle(SpanStyle(fontSize = 12.sp)) {
                                    append("分")
                                }
                            },
                            fontSize = 36.sp,
                            color = Color.White
                        )
                        Text(
                            text = "学年积分",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-30).dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "${vm.totalPointOfYear}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "学年规定积分",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "${vm.totalPointOfYear - vm.pointOfYear}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "还差",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }

            // 学习明细
            item {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        .background(Color.White)
                        .fillMaxSize()
                        .padding(top = 8.dp)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "学习明细",
                        fontSize = 16.sp,
                        color = Color(0xFF333333)
                    )
                    Text(
                        text = "最近一周获得积分情况",
                        fontSize = 14.sp,
                        color = Color(0xFF999999)
                    )

                    // 积分情况的折线图
                    ChartView(vm.pointsOfWeek, modifier = Modifier.padding(vertical = 8.dp))

                    // 日期
                    Row {
                        vm.weeks.forEach {
                            Text(
                                text = it,
                                fontSize = 12.sp,
                                color = Color(0xFF999999),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    // 今日任务提醒
                    Text(
                        text = vm.tips,
                        color = Color(0xFF149EE7),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(
                                Color(0x33149EE7)
                            )
                            .padding(8.dp)
                            .fillMaxWidth()
                    )

                    // 每日任务
                    DailyTaskContent()
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskScreenPreview() {
    TaskScreen()
}