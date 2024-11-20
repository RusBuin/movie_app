package com.example.myapplication.presentation.details

import androidx.compose.ui.res.colorResource

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.domain.model.Movie
import com.example.myapplication.presentation.details.components.DetailsTopBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myapplication.presentation.Dimens.ArticleImageHeight
import com.example.myapplication.presentation.Dimens.MediumPadding1
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.R

@Composable
fun DetailsScreen(
    movie: Movie,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
        DetailsTopBar(

            onBookMarkClick = {
                event(DetailsEvent.SaveArticle)
            },
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context = context).data(movie.poster)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(MediumPadding1))
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(
                        id = R.color.text_title
                    )
                )
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(
                        id = R.color.body
                    )
                )
                Text(
                    text = movie.originalLangauge,
                    style = MaterialTheme.typography.displayMedium,
                    color = colorResource(
                        id = R.color.body
                    )
                )
                Text(
                    text = movie.releaseDate,
                    style = MaterialTheme.typography.titleMedium,
                    color = colorResource(
                        id = R.color.body
                    )
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    MyApplicationTheme (dynamicColor = false) {
        DetailsScreen(
            movie = Movie(
                id = 1,
                poster = "https://image.tmdb.org/t/p/w500/",
                title = "TITLE",
                overview = "OVERVIEW",
                releaseDate = "2024-10-09",
                voteAverage = 6.919,
                originalLangauge = "en"
            ),
            event = {}
        ) {

        }
    }
}