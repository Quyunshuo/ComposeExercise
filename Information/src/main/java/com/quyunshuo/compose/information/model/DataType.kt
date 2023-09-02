package com.quyunshuo.compose.information.model

import androidx.compose.ui.graphics.vector.ImageVector

/***
 * 内容数据类型
 * @property title String 标题
 * @property icon ImageVector 图标
 * @constructor
 */
data class DataType(
    var title: String,
    var icon: ImageVector
)
