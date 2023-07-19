package com.quyunshuo.compose.exercise.tetris.ui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import com.quyunshuo.compose.exercise.tetris.ui.theme.BrickMatrix

/**
 * 绘制砖块小单元
 * 通过 Canvas API 绘制小砖块，Canvas API 需要在 [DrawScope] 中调用，为了方便，将 drawBrick() 方法定义为扩展函数
 *
 * @receiver DrawScope
 *
 * @param brickSize Float 砖块大小
 * @param offset Offset 在矩阵中的偏移位置
 * @param color Color 砖块颜色
 */
fun DrawScope.drawBrick(brickSize: Float, offset: Offset, color: Color) {
    // 根据 offset 计算出实际位置
    val actualLocation = Offset(offset.x * brickSize, offset.y * brickSize)

    // 绘制外部矩形边框
    val outerSize = brickSize * 0.8F
    val outerOffset = (brickSize - outerSize) / 2
    drawRect(
        color = color,
        topLeft = actualLocation + Offset(outerOffset, outerOffset),
        size = Size(outerSize, outerSize),
        style = Stroke(outerSize / 10)
    )

    // 绘制内部矩形方块
    val innerSize = brickSize * 0.5F
    val innerOffset = (brickSize - innerSize) / 2
    drawRect(
        color = color,
        topLeft = actualLocation + Offset(innerOffset, innerOffset),
        size = Size(innerSize, innerSize),
    )
}

/**
 * 绘制砖块矩阵
 *
 * @receiver DrawScope
 *
 * @param brickSize Float 砖块大小
 * @param matrix Pair<Int, Int> 横向纵向数量
 */
fun DrawScope.drawMatrix(brickSize: Float, matrix: Pair<Int, Int>) {
    (0 until matrix.first).forEach { x ->
        (0 until matrix.second).forEach { y ->
            drawBrick(brickSize, Offset(x.toFloat(), y.toFloat()), BrickMatrix)
        }
    }
}