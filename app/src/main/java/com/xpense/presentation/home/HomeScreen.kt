package com.xpense.presentation.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.xpense.R
import com.xpense.ui.theme.Shapes
import com.xpense.ui.theme.XpenseTheme
import com.xpense.ui.theme.xpenseFont
import androidx.compose.material3.MaterialTheme as MaterialTheme3

@Composable
fun HomeScreen() {
    val speed = remember { mutableStateOf(0f) }
    val lottieAnimatable = rememberLottieAnimatable()
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.menu_icon))

    LaunchedEffect(speed.value) {
        lottieAnimatable.animate(
            composition = composition,
            speed = speed.value,
        )
    }

    LaunchedEffect(composition) {
        lottieAnimatable.animate(
            composition = composition,
            speed = speed.value,
        )
    }

    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
                    .background(Color.Transparent),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LottieAnimation(
                    modifier = Modifier
                        .height(56.dp)
                        .width(56.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .padding(top = 2.dp),
                    composition = lottieAnimatable.composition,
                    progress = lottieAnimatable.progress
                )

                Text(
                    text = "Home",
                    fontFamily = xpenseFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    maxLines = 1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxHeight()
            ) {
                AccountCard()

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Analytics",
                    fontFamily = xpenseFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    maxLines = 1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    AnalyticsProgress()
                }
            }
        }
    }
}

@Composable
fun AccountCard() {
    Card(
        backgroundColor = MaterialTheme3.colorScheme.tertiary,
        modifier = Modifier
            .clip(shape = Shapes.large)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
            ) {
                Text(
                    text = "Total Balance",
                    color = Color.LightGray,
                    modifier = Modifier
                        .alpha(0.6f),
                    fontFamily = xpenseFont
                )

                Text(
                    text = "$28,067.57",
                    color = Color.White,
                    fontFamily = xpenseFont,
                    fontSize = 30.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                HorizontalProgressBar()

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "440002379236",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(0.8f),
                    fontFamily = xpenseFont,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun AnalyticsProgress() {
    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VerticalProgressBar()

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Monday",
            color = Color.DarkGray,
            modifier = Modifier
                .alpha(0.8f),
            fontFamily = xpenseFont,
            fontSize = 16.sp
        )
    }
}

@Composable
fun HorizontalProgressBar(
    indicatorHeight: Dp = 8.dp,
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.3f),
    indicatorPadding: Dp = 4.dp,
    progressColor: Color = MaterialTheme3.colorScheme.onTertiary,
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {

    val animateNumber = animateFloatAsState(
        targetValue = 10.0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(indicatorHeight)
            .padding(start = indicatorPadding, end = indicatorPadding)
    ) {
        // Background indicator
        drawLine(
            color = backgroundIndicatorColor,
            cap = StrokeCap.Round,
            strokeWidth = size.height,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f)
        )

        // Convert the downloaded percentage into progress (width of foreground indicator)
        val progress =
            (animateNumber.value / 100) * size.width // size.width returns the width of the canvas

        // Foreground indicator
        drawLine(
            color = progressColor,
            cap = StrokeCap.Round,
            strokeWidth = size.height,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = progress, y = 0f)
        )
    }
}

@Composable
fun VerticalProgressBar(
    indicatorWidth: Dp = 2.dp,
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.6f),
    indicatorPadding: Dp = 0.dp,
    progressColor: Color = MaterialTheme3.colorScheme.tertiary,
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    val animateNumber = animateFloatAsState(
        targetValue = 100.0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    Canvas(
        modifier = Modifier
            .padding(start = indicatorPadding, top = 14.dp, end = indicatorPadding)
            .height(100.dp)
            .width(indicatorWidth)
    ) {
        // Background indicator
        drawLine(
            color = backgroundIndicatorColor,
            cap = StrokeCap.Round,
            strokeWidth = 96.0f,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = 0f, y = size.height)
        )

        // Convert the downloaded percentage into progress (width of foreground indicator)
        val progress =
            (animateNumber.value / 100) * size.height // size.width returns the width of the canvas

        println("@@@ height ${size.height}")
        println("@@@ progress $progress")

        // Foreground indicator
        drawLine(
            color = progressColor,
            cap = StrokeCap.Round,
            strokeWidth = 96.0f,
            start = Offset(x = 0f, y = size.height),
            end = Offset(x = 0f, y = progress)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    XpenseTheme {
        HomeScreen()
    }
}
