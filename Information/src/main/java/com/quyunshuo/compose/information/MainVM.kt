package com.quyunshuo.compose.information

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.quyunshuo.compose.information.model.Category
import com.quyunshuo.compose.information.model.DataType

class MainVM : ViewModel() {

    /**
     * 分类数据
     */
    var categories by mutableStateOf(
        listOf(
            Category("View", "1"),
            Category("Jetpack Compose", "2"),
            Category("Swift UI", "3"),
            Category("Flutter", "4"),
            Category("KMP", "5")
        )
    )
        private set


    /**
     * 当前分类下标
     */
    var categoryIndex by mutableStateOf(0)
        private set

    /**
     * 更新分类下标
     * @param index Int 新的下标
     */
    fun updateCategoryIndex(index: Int) {
        if (categoryIndex != index) {
            categoryIndex = index
        }
    }


    /**
     * 内容类型数据
     */
    val types by mutableStateOf(
        listOf(
            DataType("相关资讯", Icons.Default.Description),
            DataType("视频课程", Icons.Default.SmartDisplay)
        )
    )

    /**
     * 当前类型下标
     */
    var currentTypeIndex by mutableStateOf(0)
        private set

    /**
     * 是否文章列表
     */
    var showArticleList by mutableStateOf(true)
        private set

    /**
     * 更新类型下标
     * @param index Int 新的下标
     */
    fun updateTypeIndex(index: Int) {
        if (currentTypeIndex != index) {
            currentTypeIndex = index
            showArticleList = currentTypeIndex == 0
        }
    }

}