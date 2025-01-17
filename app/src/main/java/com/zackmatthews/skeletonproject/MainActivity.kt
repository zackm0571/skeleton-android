package com.zackmatthews.skeletonproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.zackmatthews.skeletonproject.ui.theme.SkeletonProjectTheme
import com.zackmatthews.skeletonproject.view.EndlessLazyColumn
import com.zackmatthews.skeletonproject.view.FeedEntry

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()
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
        Box(modifier = Modifier.fillMaxSize()) {
            Timeline(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .align(Alignment.Center),
            )
        }
    }

    @Composable
    fun Timeline(modifier: Modifier = Modifier) {
        val data = viewModel.data.collectAsStateWithLifecycle().value
        EndlessLazyColumn(modifier = modifier,
            content = {
                items(data.size) { index ->
                    FeedEntry(data[index])
                }
            }, onLoadMore = {
                viewModel.fetchCats()
            }
        )
    }
}