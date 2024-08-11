sealed class Route(val route: String) {
    object Homescreen : Route("homescreen")
    object QuestionScreen : Route("questionscreen")
    object Result : Route("result?correctAnswers={correctAnswers}") {
        fun createRoute(correctAnswers: Int) = "result?correctAnswers=$correctAnswers"
    }
}
