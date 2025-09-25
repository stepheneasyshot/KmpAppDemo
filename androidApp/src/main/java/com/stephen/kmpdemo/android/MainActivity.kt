package com.stephen.kmpdemo.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.ai.edge.aicore.DownloadCallback
import com.google.ai.edge.aicore.DownloadConfig
import com.google.ai.edge.aicore.GenerativeModel
import com.google.ai.edge.aicore.content
import com.google.ai.edge.aicore.generationConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(1f)
    ) {
        Text(
            text = "Hello, World!",
            fontSize = 40.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    test()
                })
    }
}

fun test() {
    Log.i("MainActivity", "test Hello, World!")
    val generationConfig = generationConfig {
        context = appContext
        temperature = 0.2f
        topK = 16
        maxOutputTokens = 256
    }
    val downloadCallback = object : DownloadCallback {
        override fun onDownloadProgress(totalBytesDownloaded: Long) {
            super.onDownloadProgress(totalBytesDownloaded)
            Log.i("MainActivity", "onDownloadProgress: $totalBytesDownloaded")
        }
    }
    val downloadConfig = DownloadConfig(downloadCallback)
    val generativeModel = GenerativeModel(
        generationConfig = generationConfig,
        downloadConfig = downloadConfig // optional
    )
    CoroutineScope(Dispatchers.IO).launch {
        // Single string input prompt
        val input = "使用中文介绍一下你自己"
        val response = generativeModel.generateContent(input)
        Log.i("MainActivity", "${response.text}")

        // Or multiple strings as input
//        val response2 = generativeModel.generateContent(
//            content {
//                text(
//                    "I want you to act as an English proofreader. I will provide you texts\n" +
//                            "                        and I would like you to review them for any spelling, grammar, or\n" +
//                            "                        punctuation errors."
//                )
//                text(
//                    "Once you have finished reviewing the text, provide me with any\n" +
//                            "                        necessary corrections or suggestions for improving the text:"
//                )
//                text("These arent the droids your looking for.")
//            }
//        )
//        Log.i("MainActivity", "${response2.text}")
    }
}