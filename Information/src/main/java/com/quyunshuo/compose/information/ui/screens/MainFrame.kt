package com.quyunshuo.compose.information.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quyunshuo.compose.information.model.NavItem

@Composable
fun MainFrame() {

    /**
     * 底部导航栏的数据源
     */
    val navigationItems = listOf(
        NavItem(title = "Study", icon = Icons.Filled.Home),
        NavItem(title = "Task", icon = Icons.Filled.DateRange),
        NavItem(title = "My", icon = Icons.Filled.Person),
    )

    /**
     * 当前导航栏的选中索引
     */
    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    Column(Modifier.fillMaxSize()) {
        // 放具体的界面，类似于 Fragment
        Box(Modifier.weight(1f)) {
            when (selectedItem) {
                0 -> StudyScreen()
                1 -> TaskScreen()
                2 -> MineScreen()
            }
        }

        // material3 中的底部导航栏
        NavigationBar {
            navigationItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(item.icon, contentDescription = item.title) },
                    label = { Text(item.title) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }
    }
}

@Preview
@Composable
fun MainFramePreview() {
    MainFrame()
}