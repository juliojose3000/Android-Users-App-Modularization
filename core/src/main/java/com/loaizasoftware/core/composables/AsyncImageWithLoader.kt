package com.loaizasoftware.core.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter

@Composable
fun AsyncImageWithLoader(imageUrl: String, paddingValues: PaddingValues = PaddingValues(0.dp)) {

    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        contentScale = ContentScale.Crop,
    )

    val state = painter.state.collectAsState().value

    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(paddingValues)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        if (state is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(color = Color.Blue)
        }

        Image(
            painter = painter,
            contentDescription = "Image",
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(16.dp)),
        )
    }

}