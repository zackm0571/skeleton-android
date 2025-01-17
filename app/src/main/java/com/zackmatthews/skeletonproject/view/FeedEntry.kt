package com.zackmatthews.skeletonproject.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.zackmatthews.skeletonproject.domain.CatModel
import com.zackmatthews.skeletonproject.ui.theme.CARD_WIDTH
import com.zackmatthews.skeletonproject.ui.theme.FEED_SPACER

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FeedEntry(data: CatModel) {
    Spacer(modifier = Modifier.size(FEED_SPACER))
    Box(
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .wrapContentHeight()
                .width(CARD_WIDTH)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "ID: ${data.id}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )

                Spacer(modifier = Modifier.size(10.dp))

                GlideImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Transparent),
                    alignment = Alignment.Center,
                    model = data.url,
                    contentDescription = "Cat", contentScale = ContentScale.Inside
                )

                Spacer(modifier = Modifier.size(10.dp))

                DescriptionText()
            }
        }
    }
    Spacer(modifier = Modifier.size(FEED_SPACER))
}