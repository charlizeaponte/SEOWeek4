package edu.quinnipiac.seoweek4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.quinnipiac.seoweek4.databinding.FragmentDetailBinding

class detailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        arguments?.let {
            val topic = it.getString(learnFragment.ARG_PARAM1)
            val imageResId = it.getInt(learnFragment.ARG_IMAGE_RES_ID)
            val words = it.getStringArrayList(learnFragment.ARG_WORDS)

            // Update UI elements with received data
            binding.topicImageView.setImageResource(imageResId)
            binding.topicTitleTextView.text = topic
            words?.let { wordList ->
                val displayWords = wordList.take(10) // Take the first 10 words
                    .mapIndexed { index, englishWord ->
                        val translatedWord = wordList[index + 10] // Get corresponding translated word
                        "$translatedWord: $englishWord"
                    }
                binding.wordsTextView.text = displayWords.joinToString(separator = "\n")
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


