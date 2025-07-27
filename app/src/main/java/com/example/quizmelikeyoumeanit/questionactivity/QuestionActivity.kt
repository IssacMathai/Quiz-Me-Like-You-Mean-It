package com.example.quizmelikeyoumeanit.questionactivity

import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizmelikeyoumeanit.R
import com.example.quizmelikeyoumeanit.questionactivity.model.QuestionModel

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