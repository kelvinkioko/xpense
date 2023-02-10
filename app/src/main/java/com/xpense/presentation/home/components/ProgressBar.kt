package com.xpense.presentation.home.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalProgressBar(
    indicatorHeight: Dp = 100.dp,
    indicatorWidth: Dp = 12.dp,
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.6f),
    indicatorPadding: Dp = 0.dp,
    progressColor: Color = MaterialTheme.colorScheme.tertiary,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    progress: Int = 25
) {

    val animateNumber = animateFloatAsState(
        targetValue = (100 - progress).toFloat(),
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    Canvas(
        modifier = Modifier
            .padding(start = indicatorPadding, top = 14.dp, end = indicatorPadding)
            .height(indicatorHeight)
            .width(indicatorWidth)
    ) {
        val centerXPosition = size.width / 2

        // Background indicator
        drawLine(
            color = backgroundIndicatorColor,
            cap = StrokeCap.Round,
            strokeWidth = size.width,
            start = Offset(x = centerXPosition, y = 0f),
            end = Offset(x = centerXPosition, y = size.height)
        )

        val progressHeight = (animateNumber.value / 100) * size.height // size.height returns the width of the canvas

        // Foreground indicator
        drawLine(
            color = progressColor,
            cap = StrokeCap.Round,
            strokeWidth = size.width,
            start = Offset(x = centerXPosition, y = size.height),
            end = Offset(x = centerXPosition, y = progressHeight)
        )
    }
}

@Composable
fun HorizontalProgressBar(
    indicatorHeight: Dp = 8.dp,
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.3f),
    indicatorPadding: Dp = 4.dp,
    progressColor: Color = MaterialTheme.colorScheme.onTertiary,
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
