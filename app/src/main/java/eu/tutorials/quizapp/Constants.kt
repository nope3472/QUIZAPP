// Constants.kt
package eu.tutorials.quizapp

import Question

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val que1 = Question(
            id = 1,
            question = "Which logo is this?",
            imageResId = R.drawable.fcb,
            option1 = "Barcelona",
            option2 = "Chelsea",
            option3 = "PSG",
            option4 = "Bayern Munich",
            correctAnswerIndex = 0
        )
        questionList.add(que1)

        val que2 = Question(
            id = 2,
            question = "Which logo is this?",
            imageResId = R.drawable.cv,
            option1 = "Osasuna",
            option2 = "Torino",
            option3 = "Celta Vigo",
            option4 = "Aston Villa",
            correctAnswerIndex = 2
        )
        questionList.add(que2)
       val que3=Question(
           id =3,
           question = "Which logo is this?",
           imageResId = R.drawable.cao,
           option1 = "Real Betis",
           option2 = "Real Sociedad",
           option3 = "Osasuna",
           option4 = "LOSC",
           2
       )
        questionList.add(que3)
        val que4=Question(
            id =4,
            question = "Which logo is this?",
            imageResId = R.drawable.rb,
            option1 = "Real Betis",
            option2 = "Leipzig",
            option3 = "New York Red Bulls",
            option4 = "FC Red Bull Salzburg",
            1
        )
        questionList.add(que4)

        val que5=Question(
            id =5,
            question = "Which logo is this?",
            imageResId = R.drawable.benfica,
            option1 = "Benfica",
            option2 = "Porto",
            option3 = "Sporting CP",
            option4 = "Braga",
            0
        )
        questionList.add(que5)
        val que6=Question(
            id =6,
            question = "Which logo is this?",
            imageResId = R.drawable.napoli1,
            option1 = "Empoli FC",
            option2 = "Milan",
            option3 = "Atalanta BC",
            option4 = "SSC Napoli",
            3
        )
        questionList.add(que6)
        val que7=Question(
            id =7,
            question = "Which logo is this?",
            imageResId = R.drawable.reims,
            option1 = "Rennais FC",
            option2 = "Reims",
            option3 = "Sporting de Réccreo",
            option4 = "Sporting CP",
            1
        )
        questionList.add(que7)
        val que8=Question(
            id =8,
            question = "Which logo is this?",
            imageResId = R.drawable.sevilla,
            option1 = "Real Betis",
            option2 = "Valencia",
            option3 = "Sevilla",
            option4 = "Aston Villa",
            2
        )
        questionList.add(que8)
        val que9=Question(
            id =9,
            question = "Which logo is this?",
            imageResId = R.drawable.villareal,
            option1 = "Villareal",
            option2 = "Valencia",
            option3 = "Cádiz CF",
            option4 = "Real Sociedad",
            0
        )

        questionList.add(que9)
        val que10=Question(
            id =10,
            question = "Which logo is this?",
            imageResId = R.drawable.wolfs,
            option1 = "Marseille",
            option2 = "Wolfs",
            option3 = "Monteplier",
            option4 = "Watford FC",
            1
        )
        questionList.add(que10)

        return questionList
    }
}
