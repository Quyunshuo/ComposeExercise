package com.quyunshuo.compose.information.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quyunshuo.compose.information.model.ArticleEntity

@Composable
fun ArticleItem(article: ArticleEntity) {

}

@Preview
@Composable
fun ArticleItemPreview() {
    val articleEntity = ArticleEntity(
        title = "人社部向疫情防控期参与复工复产的劳动者表",
        source = "“学习强国”学习平台",
        timestamp = "2020-02-10"
    )
    ArticleItem(articleEntity)
}