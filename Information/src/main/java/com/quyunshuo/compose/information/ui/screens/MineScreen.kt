package com.quyunshuo.compose.information.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.quyunshuo.compose.information.ui.components.TopAppBar

@Composable
fun MineScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        TopAppBar {
            Text(text = "My", fontSize = 18.sp, color = Color.White)
        }
    }
}

@Preview
@Composable
fun MineScreenPreview() {
    MineScreen()
}