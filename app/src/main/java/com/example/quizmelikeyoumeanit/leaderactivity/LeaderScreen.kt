package com.example.quizmelikeyoumeanit.leaderactivity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizmelikeyoumeanit.R
import com.example.quizmelikeyoumeanit.leaderactivity.components.LeaderRow
import com.example.quizmelikeyoumeanit.leaderactivity.components.OnBackRow
import com.example.quizmelikeyoumeanit.leaderactivity.components.TopThreeSection
import com.example.quizmelikeyoumeanit.leaderactivity.model.UserModel

@Composable
fun LeaderScreen(
    topUsers: List<UserModel>,
    otherUsers: List<UserModel>,
    onBackClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.grey)),
        verticalArrangement = Arrangement.Top
    ) {
        item {
            OnBackRow(onBackClick)
        }
        item {
            TopThreeSection(topUsers)
            Spacer(modifier = Modifier.height(16.dp))
        }
        itemsIndexed(otherUsers) { index, user ->
            LeaderRow(user = user, rank = index + 4)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun LeaderScreenPreview() {
    val topUsers = listOf(
        UserModel(id = 1, name = "John Doe", pic = "person1", score = 100),
        UserModel(id = 2, name = "Jane Leader", pic = "person2", score = 95),
        UserModel(id = 3, name = "Alex Star", pic = "person3", score = 90)
    )

    val otherUsers = listOf(
        UserModel(id = 4, name = "Chris Player", pic = "person4", score = 85),
        UserModel(id = 5, name = "Pat Runner", pic = "person5", score = 80)
    )

    LeaderScreen(
        topUsers = topUsers,
        otherUsers = otherUsers,
        onBackClick = {}
    )
}
