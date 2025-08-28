package com.example.quizmelikeyoumeanit.dashboardactivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizmelikeyoumeanit.R
import com.example.quizmelikeyoumeanit.dashboardactivity.components.Banner
import com.example.quizmelikeyoumeanit.dashboardactivity.components.BottomNavigationBar
import com.example.quizmelikeyoumeanit.dashboardactivity.components.CategoryGrid
import com.example.quizmelikeyoumeanit.dashboardactivity.components.CategoryHeader
import com.example.quizmelikeyoumeanit.dashboardactivity.components.GameModeButtons
import com.example.quizmelikeyoumeanit.dashboardactivity.components.TopUserSection

@Composable
@Preview
fun MainScreen(
    onSinglePlayerClick: () -> Unit = {},
    onBoardClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.grey))
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            TopUserSection()
            Spacer(modifier = Modifier.height(16.dp))
            GameModeButtons(onSinglePlayerClick)
            Spacer(modifier = Modifier.height(32.dp))
            CategoryHeader()
            CategoryGrid()
        }
        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onItemSelected = { itemId ->
                if (itemId == R.id.Board) {
                    onBoardClick()
                }
            }
        )

    }
}