package com.example.myapplication.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.Dimens.MediumPadding1
import com.example.myapplication.presentation.Dimens.MediumPadding2
import com.example.myapplication.presentation.onboarding.Page
import com.example.myapplication.R
import com.example.myapplication.presentation.onboarding.pages
import com.example.myapplication.ui.theme.MyApplicationTheme



@Composable
fun OnBoardingPage (
    modifier: Modifier = Modifier,
    page: Page
){
Column (modifier = modifier){
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.6f),
        painter = painterResource(id = page.image),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
    Spacer(modifier = Modifier.height(MediumPadding1))
    Text(text = page.title, modifier = Modifier.padding(horizontal = MediumPadding2),
        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
        color = colorResource(id = R.color.display_small )
    )
    Spacer(modifier = Modifier.height(MediumPadding1))

    Text(text = page.description, modifier = Modifier.padding(horizontal = MediumPadding2),
        style = MaterialTheme.typography.bodyMedium,
        color = colorResource(id = R.color.text_medium)
    )
}
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPagePreview(){
    MyApplicationTheme{
        OnBoardingPage(
            page = pages[0]
        )
    }
}