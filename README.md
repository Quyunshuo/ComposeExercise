# ComposeExercise

Compose exercise

## MVI

**MVI** 即 **Model-View-Intent**，该模式与 **MVVM** 很相似，受前端框架的启发，**MVI**
更加强调数据的单向流动和唯一数据源，这与 **Compose** 提倡的设计理念非常契合，因此用在 **Compose**
项目中实现状态管理以及相关逻辑的处理。

**Compose** 与 **MVI** 的关系就如同前端开发中的 **React** 与 **Redux** 的关系，都是被广泛认可的组合方式。

- **View 层**：基于 **Compose** 打造，所有 **UI** 由代码实现
- **Model 层**：**ViewModel** 维护 **State** 的变化
- **V-M 通信**：通过 **StateFlow** 驱动 **Compose** 刷新，事件由 **Action** 分发至 **ViewModel**

## Tetris

这是一个经典的俄罗斯方块游戏，其中有三个部分：

- **GameBody**：绘制按键、处理用户输入
- **BrickMatrix**：绘制方块矩阵背景、下落中的方块
- **Scoreboard**：显示游戏得分、时钟等信息