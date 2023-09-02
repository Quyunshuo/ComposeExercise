package com.quyunshuo.compose.information.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TaskScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xB54CAF50)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Task")
    }
}