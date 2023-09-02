package com.quyunshuo.compose.information

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.quyunshuo.compose.information.model.Category

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

}