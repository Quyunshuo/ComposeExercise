package com.quyunshuo.compose.information.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ArcProgressBar(size: Dp, progress: Int, maxProcess: Int = 100) {
    Canvas(
        modifier = Modifier
            .size(size)
            .padding(4.dp)
    ) {
        /**
         * 背景圆弧
         */
        drawArc(
            color = Color(0x26FFFFFF),
            startAngle = 150f,
            sweepAngle = 240f,
            useCenter = false,
            style = Stroke(
                width = 8.dp.toPx(),
                cap = StrokeCap.Round
            )
        )

        /**
         * 进度圆弧
         */
        drawArc(
            color = Color.White,
            startAngle = 150f,
            sweepAngle = 240f * (progress.toFloat() / maxProcess.toFloat()),
            useCenter = false,
            style = Stroke(
                width = 8.dp.toPx(),
                cap = StrokeCap.Round
            )
        )
    }
}

@Preview
@Composable
fun ArcProgressBarPreview() {
    ArcProgressBar(200.dp, 85)
}