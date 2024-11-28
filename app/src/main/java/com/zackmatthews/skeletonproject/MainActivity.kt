package com.zackmatthews.skeletonproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.zackmatthews.skeletonproject.ui.theme.SkeletonProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkeletonProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(innerPadding)
                }
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun MainContent(innerPadding: PaddingValues) {
        //todo: Build the thing
        Text(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            text = "Hello World",
            textAlign = TextAlign.Center,
            fontSize = 42.sp
        )
        GlideImage(
            modifier = Modifier.fillMaxSize(),
            model = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
            contentDescription = "Cat"
        )
    }
}