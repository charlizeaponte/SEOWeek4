package edu.quinnipiac.seoweek4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class quizFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var submitButton: Button
    private lateinit var quizAdapter: QuizAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_quiz, container, false)
        initViews(rootView)
        return rootView
    }

    private fun initViews(rootView: View) {
        recyclerView = rootView.findViewById(R.id.recyclerView)
        submitButton = rootView.findViewById(R.id.submitButton)


        val quizQuestions = listOf(
            QuizQuestion(
                "How do you greet someone in a friendly way?",
                getString(R.string.translated_goodbye),
                getString(R.string.translated_hello),
                getString(R.string.translated_please),
                getString(R.string.translated_no),
                getString(R.string.translated_hello) // Correct answer
            ),
            QuizQuestion(
                "What do you call the liquid we drink to quench thirst?",
                getString(R.string.translated_milk),
                getString(R.string.translated_water),
                getString(R.string.translated_rice),
                getString(R.string.translated_bread),
                getString(R.string.translated_water) // Correct answer
            ),
            QuizQuestion(
                "How do you say 'five' in the language you're learning?",
                getString(R.string.translated_five),
                getString(R.string.translated_two),
                getString(R.string.translated_three),
                getString(R.string.translated_ten),
                getString(R.string.translated_five) // Correct answer
            ),
            QuizQuestion(
                "What do you call a vehicle with two wheels that people pedal?",
                getString(R.string.translated_car),
                getString(R.string.translated_bus),
                getString(R.string.translated_bicycle),
                getString(R.string.translated_airplane),
                getString(R.string.translated_bicycle) // Correct answer
            ),
            QuizQuestion(
                "How do you express gratitude?",
                getString(R.string.translated_please),
                getString(R.string.translated_thank_you),
                getString(R.string.translated_sorry),
                getString(R.string.translated_yes),
                getString(R.string.translated_thank_you) // Correct answer
            )
        )

        // Initialize RecyclerView and set adapter
        quizAdapter = QuizAdapter(quizQuestions)
        recyclerView.adapter = quizAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Set click listener for submit button
        submitButton.setOnClickListener {
            calculateScore(quizQuestions)
        }
    }

    private fun calculateScore(quizQuestions: List<QuizQuestion>) {
        var score = 0
        for (question in quizQuestions) {
            if (question.selectedAnswer == question.correctAnswer) {
                score++
            }
        }
        // Display the score
        Toast.makeText(context, "Your score is $score out of ${quizQuestions.size}", Toast.LENGTH_LONG).show()
    }
}
