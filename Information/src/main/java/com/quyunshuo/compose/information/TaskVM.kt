package com.quyunshuo.compose.information

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * 任务界面的 ViewModel
 */
class TaskVM : ViewModel() {

    var taskDateState by mutableStateOf("学习周期:2023.01.01-2023.12.31")
        private set

    var totalPointOfYear = 10000

    /**
     * 学年积分
     */
    var pointOfYear by mutableIntStateOf(8343)
        private set

    /**
     * 积分进度
     */
    var pointsProgress by mutableIntStateOf(((pointOfYear.toFloat() / totalPointOfYear.toFloat()) * 100f).toInt())
        private set
}