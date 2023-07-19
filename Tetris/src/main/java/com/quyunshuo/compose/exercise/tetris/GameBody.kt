package com.quyunshuo.compose.exercise.tetris

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quyunshuo.compose.exercise.tetris.ui.theme.BodyColor
import com.quyunshuo.compose.exercise.tetris.ui.theme.Purple200
import com.quyunshuo.compose.exercise.tetris.ui.theme.Purple500

@Composable
fun GameButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}, // TODO: onClick
    size: Dp,
    content: @Composable (Modifier) -> Unit
) {
    // RoundedCornerShape 绘制圆形的背景
    val backgroundShape = RoundedCornerShape(size / 2)

    Box(
        modifier = modifier
            .shadow(5.dp, shape = backgroundShape) // 阴影
            .size(size = size) // 大小
            .clip(backgroundShape) // 内容
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Purple200, Purple500),
                    startY = 0F,
                    endY = 80F
                )
            )
    ) {
        content(Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun GameBody() {

    val ButtonText = @Composable { modifier: Modifier,
                                   text: String ->
        Text(
            text, modifier = modifier,
            color = Color.White.copy(0.9f),
            fontSize = 18.sp
        )
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .background(BodyColor, RoundedCornerShape(10.dp))
            .padding(top = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            GameButton(
                Modifier.align(Alignment.TopCenter),
                onClick = {},
                size = DirectionButtonSize
            ) {
                ButtonText(it, stringResource(id = R.string.button_up))
            }

            GameButton(
                Modifier.align(Alignment.CenterStart),
                onClick = {},
                size = DirectionButtonSize
            ) {
                ButtonText(it, stringResource(id = R.string.button_left))
            }

            GameButton(
                Modifier.align(Alignment.CenterEnd),
                onClick = {},
                size = DirectionButtonSize
            ) {
                ButtonText(it, stringResource(id = R.string.button_right))
            }
            GameButton(
                Modifier.align(Alignment.BottomCenter),
                onClick = {},
                size = DirectionButtonSize
            ) {
                ButtonText(it, stringResource(id = R.string.button_down))
            }
        }
    }
}

val DirectionButtonSize = 60.dp
val RotateButtonSize = 90.dp
val SettingButtonSize = 15.dp