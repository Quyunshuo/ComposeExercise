package com.quyunshuo.compose.information

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
    var currentTypeIndex by mutableIntStateOf(0)
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

    /**
     * 轮播图数据
     * 使用 unsplash 的照片
     */
    var bannerState by mutableStateOf(
        listOf(
            "https://images.unsplash.com/photo-1657287490280-8b22b1a1259f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2071&q=80",
            "https://images.unsplash.com/photo-1606592641984-c9a1506d0705?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1932&q=80",
            "https://images.unsplash.com/photo-1585245332774-3dd2b177e7fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2058&q=80",
            "https://images.unsplash.com/photo-1638757937028-eabad8286d45?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1974&q=80",
            "https://images.unsplash.com/photo-1500027359505-e004de7ed703?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2071&q=80",
            "https://images.unsplash.com/photo-1655365225178-b1b4c59cbdb2?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80",
            "https://images.unsplash.com/photo-1548919973-5cef591cdbc9?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80",
            "https://images.unsplash.com/photo-1627484986972-e544190b8abb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2068&q=80"
        )
    )
        private set
}