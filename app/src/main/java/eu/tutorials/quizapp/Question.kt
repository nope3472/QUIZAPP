data class Question(
    val id: Int,
    val question: String,
    val imageResId: Int,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswerIndex: Int // Index of the correct option
) {

}
