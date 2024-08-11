import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument



@Composable
fun ScreenWithPinkBackground(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Blue // Change this back to pink if needed
    ) {
        CardContent(navController = navController)
    }
}

@Composable
fun CardContent(navController: NavHostController) {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Quiz App!",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "WELCOME",
                    color = Color.Black,
                    modifier = Modifier.padding(4.dp)
                )
                Text(text = "Please Enter Your Name", color = Color.Gray)

                TextField(
                    value = name,
                    onValueChange = { newValue -> name = newValue },
                    placeholder = { Text("Name") },
                    modifier = Modifier.padding(8.dp)
                )

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6F42C1)),
                    onClick = {
                        if (name.isNotEmpty()) {
                            navController.navigate(Route.QuestionScreen.route)
                        }
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "START", color = Color.White)
                }
            }
        }
    }
}
@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Route.Homescreen.route) {
        composable(Route.Homescreen.route) {
          ScreenWithPinkBackground(navController = navController)
        }
        composable(Route.QuestionScreen.route) {
            Questions(navController = navController)
        }
        composable(
            route = Route.Result.route,
            arguments = listOf(navArgument("correctAnswers") { type = NavType.IntType })
        ) { backStackEntry ->
            val correctAnswers = backStackEntry.arguments?.getInt("correctAnswers") ?: 0
            ResultScreen(correctAnswers = correctAnswers, navController = navController)
        }
    }
}



