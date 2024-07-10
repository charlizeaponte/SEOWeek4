package edu.quinnipiac.seoweek4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.quinnipiac.seoweek4.databinding.FragmentLearnBinding

class learnFragment : Fragment() {

    private var _binding: FragmentLearnBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearnBinding.inflate(inflater, container, false)
        val view = binding.root


        // Set up the RecyclerView
        val recyclerView = binding.topicsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TopicsAdapter(getTopics(), getTopicImages())
        recyclerView.adapter = adapter

        return view
    }

    private fun getTopics(): List<String> {
        return listOf(
            "Greeting and Introductions",
            "Food and Drink",
            "Numbers",
            "Family and Friends"
        )
    }

    private fun getTopicImages(): List<Int> {
        return listOf(
            R.drawable.ic_greeting, // Replace with your actual drawable resource IDs
            R.drawable.ic_food,
            R.drawable.ic_numbers,
            R.drawable.ic_family
        )
    }
}

