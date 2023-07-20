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

## Compose 基础知识

### 一、UI 部分

#### 1.Modifier

传统开发中，我们使用 **XML** 或者具体 **View** 的方法来对 **View** 进行样式上的修改，**Compose** 中设计了 **Modifier** 来对 **Compose** 组件进行样式上的设定，如边距、字体、大小、背景等。

需要注意的是，**Modifier** 修饰符的使用顺序会对结果产生影响，每一个修饰符的使用都会产生结果，下一个修饰符又在这个结果的基础上进行修改。

我们需要了解一些公共常用的 **Modifier** 修饰符：

- **Modifier.size**：设置组件的大小，宽高同时为设置的具体值
- **Modifier.background**：设置背景
- **Modifier.fillMaxSize**：宽高填满整个父组件
- **Modifier.fillMaxHeight**：高度填满整个父组件
- **Modifier.fillMaxWidth**：宽度填满整个父组件
- **Modifier.border**：添加边框
- **Modifier.padding**：添加边距

需要注意的是，**Modifier** 是用作用域的概念的，有些特定的修饰符只能在特定的组件内使用。

#### 2.常用组件

##### 2.1 Text 文本

```kotlin
@Composable
fun Text(
    text: String,									// 要显示的文本
    modifier: Modifier = Modifier,					// Modifier
    color: Color = Color.Unspecified,				// 文本颜色
    fontSize: TextUnit = TextUnit.Unspecified,		// 绘制文本时要使用的字形大小
    fontStyle: FontStyle? = null,					// 绘制字母时使用的字体变体（例如斜体）
    fontWeight: FontWeight? = null,					// 绘制文本时使用的字体厚度（例如， FontWeight.Bold）
    fontFamily: FontFamily? = null,					// 呈现文本时要使用的字体系列
    letterSpacing: TextUnit = TextUnit.Unspecified,	// 每个字母之间要添加的空格量
    textDecoration: TextDecoration? = null,			// 在文本上绘制的装饰（例如，下划线）
    textAlign: TextAlign? = null,					// 文本在段落行内的对齐方式
    lineHeight: TextUnit = TextUnit.Unspecified,	// 行高
    overflow: TextOverflow = TextOverflow.Clip,		// 应如何处理视觉溢出
    softWrap: Boolean = true,						// 控制文本是否能够换行
    maxLines: Int = Int.MAX_VALUE,					// 文本最多可以有几行
    onTextLayout: (TextLayoutResult) -> Unit = {},	// 计算新文本布局时执行的回调
    style: TextStyle = LocalTextStyle.current 		// 文本的样式配置，如颜色，字体，行高等。
)
```

需要注意的是，有些字段在 `TextStyle` 中也有提供，`Text` 参数的优先级要大于 `TextStyle`，也就是说，在参数中设置的属性，如果 `TextStyle` 有同名属性，会以 `Text` 参数为准。

##### 2.2 SelectionContainer 选中文字

`Text` 是不能被选中的，可以使用 `SelectionContainer` 对其进行包裹实现可选功能。

##### 2.3 Icon 图标

`Icon` 组件用于显示一些小图标

##### 2.4 Image 图片

`Image` 用于显示图片

```kotlin
@Composable
fun Image(
    xxx: Xxx,										// 支持的不同类型的图片资源
    contentDescription: String?,					// 描述，用于无障碍服务
    modifier: Modifier = Modifier, 					// Modifier
    alignment: Alignment = Alignment.Center, 		// 对齐方式
    contentScale: ContentScale = ContentScale.Fit, 	// 类似于 ScaleType，用于指定图片的填充样式
    alpha: Float = DefaultAlpha, 					// 不透明度
    colorFilter: ColorFilter? = null 				// 颜色过滤器
)
```

**ContentScale：**

- **Crop**：类似于 `ScaleType.centerCrop`，裁剪以保证居中填满，不拉伸比例
- **Fit**：类似于 `ScaleType.fitCenter`
- **FillHeight**：充满高
- **FillWidth**：充满宽
- **Inside**：类似于 `ScaleType.centerInside`
- **None**：不处理
- **FillBounds**：类似于 `ScaleType.fitXY`，拉伸充满宽高