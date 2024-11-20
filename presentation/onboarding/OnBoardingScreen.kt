package com.example.myapplication.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.presentation.Dimens.MediumPadding1
import com.example.myapplication.presentation.Dimens.MediumPadding2
import com.example.myapplication.presentation.Dimens.PageIndicatorWidth
import com.example.myapplication.presentation.common.NewsButton
import com.example.myapplication.presentation.common.NewsTextButton
import com.example.myapplication.presentation.onboarding.components.OnBoardingPage
import com.example.myapplication.presentation.onboarding.components.PageIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Navigator Screen") }
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)) {

                val pagerState = rememberPagerState(initialPage = 0) {
                    pages.size
                }
                val buttonState = remember {
                    derivedStateOf {
                        when (pagerState.currentPage) {
                            0 -> listOf("", "Next")
                            1 -> listOf("Back", "Next")
                            2 -> listOf("Back", "Get Started")
                            else -> emptyList()
                        }
                    }
                }

                HorizontalPager(state = pagerState) { index ->
                    OnBoardingPage(page = pages[index])
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MediumPadding2)
                           .navigationBarsPadding(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PageIndicator(
                        modifier = Modifier.width(PageIndicatorWidth),
                        pageSize = pages.size,
                        selectedPage = pagerState.currentPage
                    )

                    Spacer(modifier = Modifier.height(MediumPadding1))
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        val scope = rememberCoroutineScope()

                        if (buttonState.value[0].isNotEmpty()) {
                            NewsTextButton(
                                text = buttonState.value[0],
                                onClick = {
                                    scope.launch {
                                        pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                                    }
                                }
                            )
                        }

                        NewsButton(text = buttonState.value[1], onClick = {
                            scope.launch {
                                if (pagerState.currentPage == 2) {
                                    event(OnBoardingEvent.SaveAppEntry)
                                } else {
                                    pagerState.animateScrollToPage(
                                        page = pagerState.currentPage + 1,
                                    )
                                }
                            }
                        })
                    }
                }
            }
        }
    )
}
