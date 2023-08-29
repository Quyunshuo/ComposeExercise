package com.quyunshuo.compose.information.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.quyunshuo.compose.information.ui.theme.Blue200
import com.quyunshuo.compose.information.ui.theme.Blue700

/**
 * 标题栏高度
 */
val appBarHeight = 56.dp

/**
 * 应用的标题栏
 *
 * @param modifier Modifier
 * @param content  @Composable () -> Unit 内容
 */
@Composable
fun TopAppBar(modifier: Modifier = Modifier, content: @Composable () -> Unit) {

    val systemUiController = rememberSystemUiController()

    LaunchedEffect(key1 = Unit) {
        systemUiController.setStatusBarColor(Color.Transparent)
    }

    /**
     * 转换状态栏高度 px 为 dp
     */
    val statusBarHeightDp = with(LocalDensity.current) {
        LocalWindowInsets.current.statusBars.top.toDp()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                // 标题栏背景使用渐变色
                Brush.linearGradient(
                    listOf(
                        Blue700,
                        Blue200
                    )
                )
            )
            .height(appBarHeight + statusBarHeightDp)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 填充标题栏内容组件
        content()
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar {
        Text("标题", color = Color.White)
    }
}
