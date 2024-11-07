package com.example.myapplication.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.onboarding.components.OnBoardingPage
import com.example.myapplication.presentation.onboarding.pages
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.w3c.dom.Text


@Composable
fun NewsButton(
    text: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(6.dp)
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
        )
    }
}


@Composable
fun NewsTextButton(
    text: String,
    onClick: () -> Unit){
TextButton(onClick = onClick){
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
        color = Color.DarkGray
    )
}
}


@Preview(showBackground = true)
@Composable
fun NewsButtonPreview(){
    MyApplicationTheme{
        NewsButton(
            text = "Read News",
            onClick = {}
        )
    }
}