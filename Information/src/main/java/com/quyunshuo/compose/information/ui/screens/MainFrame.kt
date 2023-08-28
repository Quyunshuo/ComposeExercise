package com.quyunshuo.compose.information.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quyunshuo.compose.information.model.NavItem

@OptIn(ExperimentalMaterial3Api::class)
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
        mutableStateOf(0)
    }

    /**
     * 预置位置的脚手架
     */
    Scaffold(bottomBar = {

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
    }) {
        Box(modifier = Modifier.padding(it)) {
            when (selectedItem) {
                0 -> StudyScreen()
                1 -> TaskScreen()
                2 -> MineScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainFramePreview() {
    MainFrame()
}