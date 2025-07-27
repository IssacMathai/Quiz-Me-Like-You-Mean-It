package com.example.quizmelikeyoumeanit.question

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizmelikeyoumeanit.R
import com.example.quizmelikeyoumeanit.question.model.QuestionModel

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.grey)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val receivedList =
            intent.getParcelableArrayListExtra<QuestionModel>("list") ?: arrayListOf()

        setContent {
            QuestionScreen(
                questions = receivedList,
                onBackClick = { finish() },
                onFinish = {}
            )
        }
    }
}