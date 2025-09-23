package com.stephen.kmpdemo.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stephen.kmpdemo.createACrash

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                StickyHeaderExample()
            }
        }
    }
}

@Composable
fun App() {

    val scrollState = rememberLazyListState()

    LaunchedEffect(scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress) {
            LooperMsgListener.startCheckFrameTime()
        } else {
            LooperMsgListener.stopCheckFrameTime()
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(1f),
            state = scrollState,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(testItemList) {
                Text(text = it, modifier = Modifier.padding(vertical = 5.dp))
            }
        }
    }
}

val testItemList = listOf(
    "a",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
)

@Composable
fun GreetingView(text: String) {
    Text(text = text, modifier = Modifier.clickable {
//        Thread.sleep(7000L)
        createACrash()
    })
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
