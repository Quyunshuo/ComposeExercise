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
fun ArcProgressBar(
    size: Dp,
    progress: Int,
    maxProcess: Int = 100,
    startAngle: Float = 150f,
    sweepAngle: Float = 240f,
    backgroundArcColor: Color = Color(0x26FFFFFF),
    progressArcColor: Color = Color.White,
    arcWidth: Dp = 8.dp
) {
    Canvas(
        modifier = Modifier
            .size(size)
            .padding(arcWidth / 2)
    ) {
        // background arc
        drawArc(
            color = backgroundArcColor,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(
                width = arcWidth.toPx(),
                cap = StrokeCap.Round
            )
        )

        // progress arc
        drawArc(
            color = progressArcColor,
            startAngle = startAngle,
            sweepAngle = sweepAngle * (progress.toFloat() / maxProcess.toFloat()),
            useCenter = false,
            style = Stroke(
                width = arcWidth.toPx(),
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