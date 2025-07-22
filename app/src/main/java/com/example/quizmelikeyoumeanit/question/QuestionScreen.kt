package com.example.quizmelikeyoumeanit.question

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizmelikeyoumeanit.R
import com.example.quizmelikeyoumeanit.question.model.QuestionModel
import com.example.quizmelikeyoumeanit.question.model.QuestionUiState

@Composable
fun QuestionScreen(
    questions: List<QuestionModel>,
    onFinish: (finalscore: Int) -> Unit,
    onBackClick: () -> Unit
) {
    var state by remember {
        mutableStateOf(
            QuestionUiState(questions = questions)
        )
    }

    val currentQuestion = state.questions[state.currentIndex]
    var selectedAnswer = currentQuestion.clickedAnswer
    val context = LocalContext.current
    val imageResId = remember(key1 = currentQuestion.picPath) {
        context.resources.getIdentifier(
            currentQuestion.picPath ?: "",
            "drawable",
            context.packageName
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.grey))
    ){
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { onBackClick }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null
                    )
                }
                Spacer(Modifier.width(16.dp))
                Text(
                    text = "Solo",
                    fontSize = 20.sp,
                    color = colorResource(R.color.navy_blue),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        item {
            // Questions
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Question ${state.currentIndex + 1}/10",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = {
                        if (state.currentIndex > 0) {
                            selectedAnswer = null
                            state = state.copy(currentIndex = state.currentIndex - 1)
                        }
                    }
                ) {
                    Icon(painterResource(R.drawable.left_arrow), contentDescription = null)
                }
                IconButton(
                    onClick = {
                        if (state.currentIndex == 9) {
                            onFinish(state.score)
                        } else {
                            selectedAnswer = null
                            state = state.copy(currentIndex = state.currentIndex - 1)
                        }
                    }
                ) {
                    Icon(painterResource(R.drawable.right_arrow), contentDescription = null)
                }
            }
        }

        item {
            LinearProgressIndicator(
                progress = (state.currentIndex + 1) / 10f,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(14.dp)
                    .clip(RoundedCornerShape(50)),
                color = colorResource(R.color.orange),
                trackColor = Color(0xffd1d1d1)
            )
        }
        item {
            Text(
                text = currentQuestion.question ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                textAlign = TextAlign.Center,
                color = colorResource(R.color.navy_blue),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Image(
                painterResource(imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 24.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        }


    }
}

@Preview
@Composable
fun QuestionScreenPreview() {
    val questions = listOf(
        QuestionModel(
            id = 1,
            question = "What is the capital of France?",
            answer_1 = "Berlin",
            answer_2 = "Madrid",
            answer_3 = "Paris",
            answer_4 = "Rome",
            correctAnswer = "Paris",
            score = 10,
            picPath = "q_1",
            clickedAnswer = null
        )
    )
    QuestionScreen(
        questions = questions,
        onFinish = {},
        onBackClick = {})
}