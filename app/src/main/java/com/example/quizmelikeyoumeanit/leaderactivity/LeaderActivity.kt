package com.example.quizmelikeyoumeanit.leaderactivity

import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizmelikeyoumeanit.R
import com.example.quizmelikeyoumeanit.leaderactivity.model.UserModel

class LeaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.grey)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val topUsers = loadData().take(3)
        val otherUsers = loadData().drop(3)

        setContent {
            LeaderScreen(
                topUsers = topUsers,
                otherUsers = otherUsers,
                onBackClick = { finish() })
        }
    }

    private fun loadData(): List<UserModel> {
        return listOf(
            UserModel(1, "Saffron", "person1", 1100),
            UserModel(2, "Danny", "person2", 800),
            UserModel(3, "Jim", "person3", 3000),
            UserModel(4, "Huck", "person4", 4000),
            UserModel(5, "Finn", "person5", 5600),
            UserModel(6, "Benedict Eggs", "person6", 7800),
            UserModel(7, "Jared Henk", "person7", 1939),
            UserModel(8, "Rip Torn", "person8", 4333),
            UserModel(9, "John Stewart", "person9", 3888),
            UserModel(10, "Viola Davis", "person10", 900),
        )
    }
}