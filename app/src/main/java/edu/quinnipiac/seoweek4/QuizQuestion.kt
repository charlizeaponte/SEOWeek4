package edu.quinnipiac.seoweek4

data class QuizQuestion(
    val question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctAnswer: String,
    var selectedAnswer: String? = null
)
