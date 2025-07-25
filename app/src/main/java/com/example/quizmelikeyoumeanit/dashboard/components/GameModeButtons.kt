package com.example.quizmelikeyoumeanit.dashboard.components

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizmelikeyoumeanit.R

@Composable
@Preview
fun GameModeButtons(onSinglePlayerClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .height(145.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        GameButton(
            backgroundColour = R.color.blue,
            iconRes = R.drawable.btn1,
            text = "Create Quiz",
            modifier = Modifier
                .weight(1f)
        )
        Spacer(Modifier.width(12.dp))
        GameButton(
            backgroundColour = R.color.purple,
            iconRes = R.drawable.btn2,
            text = "Solo",
            modifier = Modifier
                .weight(1f)
        )
        Spacer(Modifier.width(12.dp))
        GameButton(
            backgroundColour = R.color.orange,
            iconRes = R.drawable.btn3,
            text = "Multiplayer",
            modifier = Modifier
                .weight(1f)
        )
    }
}


@Composable
fun GameButton(
    backgroundColour: Int,
    iconRes: Int,
    text: String,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .clip(RoundedCornerShape(10.dp))
            .background(color = colorResource(id = backgroundColour))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = text,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )
    }


}

//@Preview
@Composable
fun GameButtonPreview() {
    GameButton(
        backgroundColour = R.color.purple_200,
        iconRes = R.drawable.ic_launcher_background,
        text = "Single",
        onClick = {}
    )
}
