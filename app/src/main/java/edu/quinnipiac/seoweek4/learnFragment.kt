package edu.quinnipiac.seoweek4

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.quinnipiac.seoweek4.databinding.FragmentLearnBinding

class learnFragment : Fragment() {

    private var _binding: FragmentLearnBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val ARG_PARAM1 = "topic"
        const val ARG_IMAGE_RES_ID = "imageResId"
        const val ARG_WORDS = "words"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearnBinding.inflate(inflater, container, false)
        val view = binding.root

        // Set up the RecyclerView
        val recyclerView = binding.topicsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TopicsAdapter(getTopics(), getTopicImages()) { topic, imageResId ->
            val words = getWordsForTopic(topic)
            val bundle = Bundle().apply {
                putString(ARG_PARAM1, topic)
                putInt(ARG_IMAGE_RES_ID, imageResId)
                putStringArrayList(ARG_WORDS, ArrayList(words))
            }
            findNavController().navigate(R.id.action_learnFragment_to_detailFragment, bundle)
        }
        recyclerView.adapter = adapter

        return view
    }

    private fun getTopics(): List<String> {
        return listOf(
            "Greeting and Introductions",
            "Food and Drink",
            "Numbers",
            "Vehicles"
        )
    }

    private fun getTopicImages(): List<Int> {
        return listOf(
            R.drawable.ic_greeting,
            R.drawable.ic_food1,
            R.drawable.ic_numbers,
            R.drawable.ic_vehicle
        )
    }

    private fun getWordsForTopic(topic: String): List<String> {
        return when (topic) {
            "Greeting and Introductions" -> listOf(
                getString(R.string.english_hello),
                getString(R.string.english_goodbye),
                getString(R.string.english_please),
                getString(R.string.english_thank_you),
                getString(R.string.english_yes),
                getString(R.string.english_no),
                getString(R.string.english_how),
                getString(R.string.english_sorry),
                getString(R.string.english_your_name),
                getString(R.string.english_my_name),
                getString(R.string.translated_hello),
                getString(R.string.translated_goodbye),
                getString(R.string.translated_please),
                getString(R.string.translated_thank_you),
                getString(R.string.translated_yes),
                getString(R.string.translated_no),
                getString(R.string.translated_how),
                getString(R.string.translated_sorry),
                getString(R.string.translated_your_name),
                getString(R.string.translated_my_name)
            )
            "Food and Drink" -> listOf(
                getString(R.string.english_apple),
                getString(R.string.english_bread),
                getString(R.string.english_cheese),
                getString(R.string.english_chicken),
                getString(R.string.english_fish),
                getString(R.string.english_meat),
                getString(R.string.english_milk),
                getString(R.string.english_orange),
                getString(R.string.english_rice),
                getString(R.string.english_water),
                getString(R.string.translated_apple),
                getString(R.string.translated_bread),
                getString(R.string.translated_cheese),
                getString(R.string.translated_chicken),
                getString(R.string.translated_fish),
                getString(R.string.translated_meat),
                getString(R.string.translated_milk),
                getString(R.string.translated_orange),
                getString(R.string.translated_rice),
                getString(R.string.translated_water)
            )
            "Numbers" -> listOf(
                getString(R.string.english_one),
                getString(R.string.english_two),
                getString(R.string.english_three),
                getString(R.string.english_four),
                getString(R.string.english_five),
                getString(R.string.english_six),
                getString(R.string.english_seven),
                getString(R.string.english_eight),
                getString(R.string.english_nine),
                getString(R.string.english_ten),
                getString(R.string.translated_one),
                getString(R.string.translated_two),
                getString(R.string.translated_three),
                getString(R.string.translated_four),
                getString(R.string.translated_five),
                getString(R.string.translated_six),
                getString(R.string.translated_seven),
                getString(R.string.translated_eight),
                getString(R.string.translated_nine),
                getString(R.string.translated_ten)
            )
            "Vehicles" -> listOf(
                getString(R.string.english_bicycle),
                getString(R.string.english_car),
                getString(R.string.english_bus),
                getString(R.string.english_motorcycle),
                getString(R.string.english_airplane),
                getString(R.string.english_train),
                getString(R.string.english_boat),
                getString(R.string.english_truck),
                getString(R.string.english_helicopter),
                getString(R.string.english_subway),
                getString(R.string.translated_bicycle),
                getString(R.string.translated_car),
                getString(R.string.translated_bus),
                getString(R.string.translated_motorcycle),
                getString(R.string.translated_airplane),
                getString(R.string.translated_train),
                getString(R.string.translated_boat),
                getString(R.string.translated_truck),
                getString(R.string.translated_helicopter),
                getString(R.string.translated_subway)
            )
            else -> emptyList()
        }
    }
}


