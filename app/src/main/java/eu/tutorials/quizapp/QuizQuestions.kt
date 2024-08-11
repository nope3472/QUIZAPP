import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorials.quizapp.Constants
import Question
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eu.tutorials.quizapp.R

@Composable
fun Questions(navController: NavHostController) {
    val questions = Constants.getQuestions()
    var currentQuestionIndex by remember { mutableStateOf(0) }
    val totalQuestions = questions.size

    var selectedOption by remember { mutableStateOf<String?>(null) }
    var isSubmitted by remember { mutableStateOf(false) }
    var correctAnswers by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (currentQuestionIndex < totalQuestions) {
            LinearProgressIndicator(
                progress = currentQuestionIndex / totalQuestions.toFloat(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .padding(bottom = 8.dp)
            )

            Text(
                text = "Question ${currentQuestionIndex + 1} of $totalQuestions",
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            QuestionItem(
                question = questions[currentQuestionIndex],
                selectedOption = selectedOption,
                isSubmitted = isSubmitted,
                onOptionSelected = { option -> selectedOption = option },
                onSubmit = {
                    if (selectedOption != null) {
                        isSubmitted = true
                        val correctOptionText = listOf(
                            questions[currentQuestionIndex].option1,
                            questions[currentQuestionIndex].option2,
                            questions[currentQuestionIndex].option3,
                            questions[currentQuestionIndex].option4
                        )[questions[currentQuestionIndex].correctAnswerIndex]

                        if (selectedOption == correctOptionText) {
                            correctAnswers++
                        }
                    }
                },
                onNext = {
                    if (currentQuestionIndex < totalQuestions - 1) {
                        currentQuestionIndex++
                        selectedOption = null
                        isSubmitted = false
                    } else {
                        navController.navigate(Route.Result.createRoute(correctAnswers))
                    }
                }
            )
        }
    }
}



@Composable
fun QuestionItem(
    question: Question,
    selectedOption: String?,
    isSubmitted: Boolean,
    onOptionSelected: (String) -> Unit,
    onSubmit: () -> Unit,
    onNext: () -> Unit
) {
    val options = listOf(question.option1, question.option2, question.option3, question.option4)
    val correctOptionText = options[question.correctAnswerIndex]

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = question.imageResId),
                contentDescription = question.question,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 8.dp)
            )

            Text(
                text = question.question,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                options.forEach { option ->
                    val buttonColor = when {
                        isSubmitted && option == correctOptionText -> Color.Yellow
                        isSubmitted && option == selectedOption && option != correctOptionText -> Color.Red
                        !isSubmitted && option == selectedOption -> Color.Gray
                        else -> Color.Blue
                    }
                    TextOption(
                        text = option,
                        buttonColor = buttonColor,
                        onClick = {
                            if (!isSubmitted) {
                                onOptionSelected(option)
                            }
                        }
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onSubmit,
                    enabled = selectedOption != null && !isSubmitted
                ) {
                    Text("Submit")
                }

                Button(
                    onClick = onNext,
                    enabled = isSubmitted
                ) {
                    Text("Next")
                }
            }
        }
    }
}

@Composable
fun TextOption(
    text: String,
    buttonColor: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
            color = Color.White
        )
    }
}
@Composable
fun ResultScreen(correctAnswers: Int, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cong),
            contentDescription = "Congratulations",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = "Congratulations!",
            style = MaterialTheme.typography.headlineLarge.copy(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "You've completed all questions.",
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Your score is $correctAnswers out of 10.",
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = { navController.navigate(Route.Homescreen.route) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Back to Home")
        }
    }
}
