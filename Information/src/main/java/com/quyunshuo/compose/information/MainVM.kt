package com.quyunshuo.compose.information

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.quyunshuo.compose.information.model.ArticleEntity
import com.quyunshuo.compose.information.model.Category
import com.quyunshuo.compose.information.model.DataType
import com.quyunshuo.compose.information.model.VideoEntity

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
    var categoryIndex by mutableIntStateOf(0)
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

    val notificationList = listOf(
        "时间会冲淡一切，但它也会让人变得更加坚强。 - 《围城》 金庸",
        "人生就像一本书，每个人都是其中的一章节。 - 《活着》 余华",
        "爱情是一种甜蜜的负担，但它也是生活的动力。 - 《红楼梦》 曹雪芹",
        "命运如同无形的红线，将人们紧密地联系在一起。 - 《平凡的世界》 路遥",
        "人生充满了起起落落，但每一次跌倒都是为了更强大的站起来。 - 《许三观卖血记》 余华",
        "生活中的每个选择都会带来不同的结果，我们要学会承担自己的选择。 - 《活着》 余华",
        "真正的力量来自内心的坚定和勇气，而不是外在的权势和财富。 - 《平凡的世界》 路遥",
        "人生不止眼前的苟且，还有诗和远方。 - 《边城》 沈从文",
        "生活中最珍贵的东西常常被我们忽略，直到失去才会后悔莫及。 - 《红楼梦》 曹雪芹",
        "每个人都有自己的故事，我们应该学会尊重和理解他人的选择和经历。 - 《围城》 金庸"
    )

    var articleList by mutableStateOf(
        listOf(
            ArticleEntity(
                title = "1.人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            ),
            ArticleEntity(
                title = "2.人社部向疫情防控期参与复工复产的劳动者表人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            ),
            ArticleEntity(
                title = "3.人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            ),
            ArticleEntity(
                title = "4.人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            ),
            ArticleEntity(
                title = "5.人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            ),
            ArticleEntity(
                title = "6.人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            ),
            ArticleEntity(
                title = "7.人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            ),
            ArticleEntity(
                title = "8.人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            ),
            ArticleEntity(
                title = "9.人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            ),
            ArticleEntity(
                title = "10.人社部向疫情防控期参与复工复产的劳动者表",
                source = "“学习强国”学习平台",
                timestamp = "2020-02-10"
            )
        )
    )
        private set

    var videoList by mutableStateOf(
        listOf(
            VideoEntity(
                title = "1.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            ),
            VideoEntity(
                title = "2.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            ),
            VideoEntity(
                title = "3.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            ),
            VideoEntity(
                title = "4.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            ),
            VideoEntity(
                title = "5.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            ),
            VideoEntity(
                title = "6.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            ),
            VideoEntity(
                title = "7.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            ),
            VideoEntity(
                title = "8.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            ),
            VideoEntity(
                title = "9.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            ),
            VideoEntity(
                title = "10.行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://images.unsplash.com/photo-1580860749755-f49eb5509d55?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3774&q=80"
            )
        )
    )
        private set

}