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
- **Modifier.clip**：将内容裁切至 `Shape`
- **Modifier.clickable**：点击事件
- **Modifier.combinedClickable**：点击、双击、长按事件，该修饰符目前还是实验性API需要酌情使用
- **Modifier.indication**：在发生互动时为此组件绘制视觉效果
- **Modifier.shadow**：绘制阴影

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


#### 3.布局

##### 3.1 Column 垂直方向线性布局

该布局会将布局中的元素垂直进行排列。

##### 3.2 Row 水平方向线性布局

该布局会将布局中的元素水平进行排列。

#### 3.3 Box 绝对布局

该布局允许在自由位置放置子元素，可以使用 `Modifier.offset()` 来指定子元素的位置。`Box` 适用于需要自由定位子元素的场景，比如创建自定义布局或实现复杂的 UI 效果。

#### 3.4 ConstraintLayout 约束布局

该布局通过约束关系来定位子元素。可以使用 `Modifier.constrainAs()` 和 `Modifier.constrainTo()` 来定义子元素之间的约束关系。`ConstraintLayout` 适用于复杂的布局，可以实现灵活的UI设计。
