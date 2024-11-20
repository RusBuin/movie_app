package com.example.myapplication.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myapplication.presentation.Dimens.ArticleCardSize
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.presentation.Dimens.ExtraSmallPadding
import com.example.myapplication.R
import com.example.myapplication.domain.model.Movie


@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    movie: com.example.myapplication.domain.model.Movie,
    onClick: () -> Unit
) {

    val context = LocalContext.current
    val imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster}"

    Row(modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context)
                .data(imageUrl)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun ArticleCardPreview() {
    MyApplicationTheme {
        MovieCard(
            movie = Movie(
                id = TODO(),
                poster = TODO(),
                title = TODO(),
                overview = TODO(),
                releaseDate = TODO(),
                voteAverage = TODO(),
                originalLangauge = TODO()
            ),
            onClick = {}
        )
    }
}
