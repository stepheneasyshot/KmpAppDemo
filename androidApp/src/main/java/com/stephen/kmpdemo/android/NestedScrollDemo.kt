package com.stephen.kmpdemo.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StickyHeaderExample() {
    val toolbarHeight = 56.dp
    val headerHeight = 100.dp
    val headerHeightPx = with(LocalDensity.current) { headerHeight.toPx() }

    // 跟踪头部偏移量
    var headerOffsetHeightPx by remember { mutableFloatStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = headerOffsetHeightPx + delta

                // 限制偏移范围：从0到-headerHeightPx（完全隐藏）
                headerOffsetHeightPx = newOffset.coerceIn(-headerHeightPx, 0f)

                // 返回消耗的偏移量
                return Offset(0f, delta - (newOffset - headerOffsetHeightPx))
            }

            override suspend fun onPreFling(available: Velocity): Velocity {
                // 快速滑动时，根据方向决定是否吸顶
                val shouldSnap = available.y < 0 && headerOffsetHeightPx < 0
                return if (shouldSnap) {
                    Velocity(0f, available.y)
                } else {
                    Velocity.Zero
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("吸顶效果演示") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .nestedScroll(nestedScrollConnection)
        ) {
            // 可吸顶的头部
            Box(
                modifier = Modifier
                    .height(headerHeight)
                    .offset { IntOffset(0, headerOffsetHeightPx.roundToInt()) }
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .zIndex(1f) // 确保头部在内容上方
            ) {
                Text(
                    "可吸顶的头部区域",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // 内容列表
            LazyColumn {
                items(50) { index ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Text(
                            text = "列表项 $index",
                            modifier = Modifier.padding(16.dp),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}