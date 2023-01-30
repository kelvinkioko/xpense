package com.xpense.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.xpense.R
import com.xpense.ui.theme.XpenseTheme
import com.xpense.ui.theme.xpenseFont

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
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    XpenseTheme {
        HomeScreen()
    }
}
