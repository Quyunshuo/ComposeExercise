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

    /**
     * 一周积分情况
     */
    var pointsOfWeek by mutableStateOf(listOf(0.0, 2.0, 6.0, 9.5, 10.0, 15.0, 5.0))
        private set

    /**
     * 日期
     */
    val weeks = listOf("02.05", "02.06", "02.07", "02.08", "02.09", "02.10", "今日")

    /**
     * 今日积分
     */
    private var todayPoint = 13

    /**
     * 今日提醒文字
     */
    var tips by mutableStateOf("今日获得0积分，快去完成下面任务吧")
        private set

    /**
     * 更新任务提醒文字
     */
    fun updateTips() {
        tips = when (todayPoint) {
            0 -> "今日获得0积分，快去完成下面任务吧"
            in 1..14 -> "今日获得${todayPoint}积分，快去完成下面任务吧"
            else -> "今日获得${todayPoint}积分，已经完成任务"
        }
    }
}