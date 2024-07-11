package edu.quinnipiac.seoweek4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class QuizAdapter(private val quizQuestions: List<QuizQuestion>) :
    RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    inner class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionText: TextView = itemView.findViewById(R.id.questionTextView)
        val optionButtonA: Button = itemView.findViewById(R.id.optionButtonA)
        val optionButtonB: Button = itemView.findViewById(R.id.optionButtonB)
        val optionButtonC: Button = itemView.findViewById(R.id.optionButtonC)
        val optionButtonD: Button = itemView.findViewById(R.id.optionButtonD)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.quiz_item, parent, false)
        return QuizViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val currentQuestion = quizQuestions[position]
        holder.questionText.text = currentQuestion.question
        holder.optionButtonA.text = currentQuestion.optionA
        holder.optionButtonB.text = currentQuestion.optionB
        holder.optionButtonC.text = currentQuestion.optionC
        holder.optionButtonD.text = currentQuestion.optionD

        // Set click listeners for option buttons
        holder.optionButtonA.setOnClickListener {
            currentQuestion.selectedAnswer = currentQuestion.optionA
            notifyItemChanged(position)
        }
        holder.optionButtonB.setOnClickListener {
            currentQuestion.selectedAnswer = currentQuestion.optionB
            notifyItemChanged(position)
        }
        holder.optionButtonC.setOnClickListener {
            currentQuestion.selectedAnswer = currentQuestion.optionC
            notifyItemChanged(position)
        }
        holder.optionButtonD.setOnClickListener {
            currentQuestion.selectedAnswer = currentQuestion.optionD
            notifyItemChanged(position)
        }

        // Highlight selected answer
          val selectedColor = ContextCompat.getColor(holder.itemView.context, R.color.selected_answer)
        val defaultColor = ContextCompat.getColor(holder.itemView.context, R.color.default_answer)

        holder.optionButtonA.setBackgroundColor(if (currentQuestion.selectedAnswer == currentQuestion.optionA) selectedColor else defaultColor)
        holder.optionButtonB.setBackgroundColor(if (currentQuestion.selectedAnswer == currentQuestion.optionB) selectedColor else defaultColor)
        holder.optionButtonC.setBackgroundColor(if (currentQuestion.selectedAnswer == currentQuestion.optionC) selectedColor else defaultColor)
        holder.optionButtonD.setBackgroundColor(if (currentQuestion.selectedAnswer == currentQuestion.optionD) selectedColor else defaultColor)
    }

    override fun getItemCount(): Int {
        return quizQuestions.size
    }
}
