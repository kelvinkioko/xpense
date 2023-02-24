package com.xpense.presentation.home

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
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
import com.xpense.presentation.home.components.VerticalProgressBar
import com.xpense.ui.theme.Shapes
import com.xpense.ui.theme.XpenseTheme
import com.xpense.ui.theme.xpenseFont
import androidx.compose.material3.MaterialTheme as MaterialTheme3

@Composable
fun HomeScreen() {
    val speed = remember { mutableStateOf(0f) }
    val lottieAnimatable = rememberLottieAnimatable()
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.menu_icon))

    // Get local density from composable
    val localDensity = LocalDensity.current

    // Create element height in pixel state
    var columnHeightPx by remember { mutableStateOf(0f) }

    // Create element height in dp state
    var columnHeightDp by remember { mutableStateOf(0.dp) }
    var cardWidthDp by remember { mutableStateOf(0.dp) }

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
                .onGloballyPositioned { coordinates ->
                    cardWidthDp = with(localDensity) {
                        (coordinates.size.width * 0.7)
                            .toInt()
                            .toDp()
                    }
                }
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxHeight()
            ) {
                LazyRow {
                    item {
                        AccountCard(cardWidthDp = cardWidthDp)
                        AccountCard(cardWidthDp = cardWidthDp)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Recent Transactions",
                    fontFamily = xpenseFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    maxLines = 1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                TransactionItem()
            }
        }
    }
}

@Composable
fun AccountCard(cardWidthDp: Dp) {
    // Get local density from composable
    val localDensity = LocalDensity.current

    // Create element height in pixel state
    var columnHeightPx by remember { mutableStateOf(0f) }

    // Create element height in dp state
    var columnHeightDp by remember { mutableStateOf(0.dp) }

    Card(
        backgroundColor = MaterialTheme3.colorScheme.tertiary,
        modifier = Modifier
            .clip(shape = Shapes.large)
            .padding(horizontal = 16.dp)
            .width(cardWidthDp)
            .wrapContentHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .onGloballyPositioned { coordinates ->
                        // Set column height using the LayoutCoordinates
                        columnHeightPx = coordinates.size.height.toFloat()
                        columnHeightDp = with(localDensity) { coordinates.size.height.toDp() }
                    },
            ) {
                Text(
                    text = "Saving",
                    color = Color.White,
                    fontFamily = xpenseFont,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Total Balance",
                    color = Color.LightGray,
                    modifier = Modifier
                        .alpha(0.6f),
                    fontFamily = xpenseFont
                )

                Text(
                    text = "$2,888,067.57",
                    color = Color.White,
                    fontFamily = xpenseFont,
                    fontSize = 28.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "**** 9236",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(0.8f),
                    fontFamily = xpenseFont,
                    fontSize = 16.sp
                )
            }

            VerticalProgressBar(
                indicatorHeight = columnHeightDp - 16.dp,
                indicatorWidth = 14.dp,
                backgroundIndicatorColor = Color.Black.copy(alpha = 0.3f),
                progressColor = Color.White
            )
        }
    }
}

@Composable
fun TransactionItem() {
    Card(
        modifier = Modifier
            .clip(shape = Shapes.large)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Tuesday 14, 2023",
                    color = Color.Black,
                    fontFamily = xpenseFont,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .alpha(0.8f)
                )

                Text(
                    text = "KES 1500.00",
                    color = MaterialTheme3.colorScheme.primary,
                    fontFamily = xpenseFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Divider(
                color = Color.LightGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .alpha(0.2f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SingleTransactionItem()
                SingleTransactionItem()
            }
        }
    }
}

@Composable
fun SingleTransactionItem() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Savings",
                color = Color.DarkGray,
                fontFamily = xpenseFont,
                fontSize = 16.sp
            )

            Text(
                text = "Save for a new car",
                color = Color.LightGray,
                fontFamily = xpenseFont,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }

        Text(
            text = "KES 100.00",
            color = Color.DarkGray,
            fontFamily = xpenseFont,
            fontSize = 16.sp
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
