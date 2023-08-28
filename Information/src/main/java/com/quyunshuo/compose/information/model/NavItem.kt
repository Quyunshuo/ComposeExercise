package com.quyunshuo.compose.information.model

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * 代表底部导航栏 item 的数据类
 *
 * @property title String 标题
 * @property icon ImageVector 图标
 * @constructor
 */
data class NavItem(
    val title: String,
    val icon: ImageVector
)