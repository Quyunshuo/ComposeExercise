package com.quyunshuo.compose.exercise.tetris.ui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipRect
import com.quyunshuo.compose.exercise.tetris.ui.theme.BrickSpirit

/**
 * Shape 砖块
 * 随机自然下落的预定义俄罗斯砖块，每个形状由四个砖块组成
 */
val SpriteType = listOf(
    listOf(Offset(1F, -1F), Offset(1F, 0F), Offset(0F, 0F), Offset(0F, 1F)), // Z
    listOf(Offset(0F, -1F), Offset(0F, 0F), Offset(1F, 0F), Offset(1F, 1F)), // S
    listOf(Offset(0F, -1F), Offset(0F, 0F), Offset(0F, 1F), Offset(0F, 2F)), // I
    listOf(Offset(0F, 1F), Offset(0F, 0F), Offset(0F, -1F), Offset(1F, 0F)), // T
    listOf(Offset(1F, 0F), Offset(0F, 0F), Offset(1F, -1F), Offset(0F, -1F)), // O
    listOf(Offset(0F, -1F), Offset(1F, -1F), Offset(1F, 0F), Offset(1F, 1F)), // L
    listOf(Offset(1F, -1F), Offset(0F, -1F), Offset(0F, 0F), Offset(0F, 1F)), // J
)


/**
 * 该类代表随机下落的俄罗斯方块
 *
 * @property shape List<Offset> 预定义的砖块
 * @property offset Offset 相对于屏幕的偏移量
 * @property location List<Offset> 具体位置
 */
data class Sprite(
    val shape: List<Offset> = emptyList(),
    val offset: Offset = Offset(0F, 0F)
) {
    val location: List<Offset> = shape.map { it + offset }
}

/**
 * 绘制下落的方块，内部通过调用 [drawBrick] 对 [Sprite] 的每个砖块进行绘制
 *
 * @receiver DrawScope
 *
 * @param sprite Sprite 下落的预定义砖块
 * @param brickSize Float 砖块大小
 * @param matrix Pair<Int, Int>
 */
fun DrawScope.drawSprite(sprite: Sprite, brickSize: Float, matrix: Pair<Int, Int>) {
    clipRect(
        left = 0F,
        top = 0F,
        right = matrix.first * brickSize,
        bottom = matrix.second * brickSize
    ) {
        sprite.location.forEach {
            drawBrick(brickSize, Offset(it.x, it.y), BrickSpirit)
        }
    }
}
