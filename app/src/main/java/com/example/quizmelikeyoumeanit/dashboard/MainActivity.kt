package com.example.quizmelikeyoumeanit.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.quizmelikeyoumeanit.R
import com.example.quizmelikeyoumeanit.dashboard.screens.MainScreen
import com.example.quizmelikeyoumeanit.question.QuestionActivity
import com.example.quizmelikeyoumeanit.question.model.QuestionModel
import com.example.quizmelikeyoumeanit.ui.theme.QuizMeLikeYouMeanItTheme
import java.util.ArrayList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


        setContent {
            MainScreen(onSinglePlayerClick = {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)
            }, onBoardClick = {})
        }
    }

    private fun questionList(): List<QuestionModel> {
        return listOf(
            QuestionModel(
                1,
                "Which planet is the largest planet in the solar system?",
                "Earth",
                "Mars",
                "Neptune",
                "Jupiter",
                "d",
                5,
                "q_1",
                null
            ),
            QuestionModel(
                2,
                "Which country is the largest country in the world by land area?",
                "Russia",
                "Canada",
                "United States",
                "China",
                "a",
                5,
                "q_2",
                null
            ),
            QuestionModel(
                3,
                "Which of the following substances is used as an anti-cancer medication?",
                "Cheese",
                "Lemon juice",
                "Cannabis",
                "Paspalum",
                "c",
                5,
                "q_3",
                null
            ),
            QuestionModel(
                4,
                "Which moon has an atmosphere?",
                "Luna",
                "Phobos",
                "Venus' moon",
                "None of the above",
                "d",
                5,
                "q_4",
                null
            ),
            QuestionModel(
                5,
                "Which symbol represents the element with atomic number 6?",
                "O",
                "H",
                "C",
                "N",
                "c",
                5,
                "q_5",
                null
            ),
            QuestionModel(
                6,
                "Who is credited with inventing theater as we know it?",
                "Shakespeare",
                "Arthur Miller",
                "Ashkouri",
                "Ancient Greeks",
                "d",
                5,
                "q_6",
                null
            ),
            QuestionModel(
                7,
                "Which ocean is the largest?",
                "Pacific",
                "Atlantic",
                "Indian",
                "Arctic",
                "a",
                5,
                "q_7",
                null
            ),
            QuestionModel(
                8,
                "Which religions are most practiced?",
                "Islam, Christianity, Judaism",
                "Buddhism, Hinduism, Sikhism",
                "Zoroastrianism, Brahmanism",
                "Taoism, Shintoism",
                "a",
                5,
                "q_8",
                null
            ),
            QuestionModel(
                9,
                "Which continent has the most independent countries?",
                "Asia",
                "Europe",
                "Africa",
                "Americas",
                "c",
                5,
                "q_9",
                null
            ),
            QuestionModel(
                10,
                "Which ocean has the greatest average depth?",
                "Pacific",
                "Atlantic",
                "Indian",
                "Southern",
                "d",
                5,
                "q_10",
                null
            )
        )
    }
}