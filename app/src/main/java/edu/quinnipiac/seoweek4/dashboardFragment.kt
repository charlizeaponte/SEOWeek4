package edu.quinnipiac.seoweek4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class dashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val userData = UserData(requireContext())
        lifecycleScope.launch {
            val sub1 = userData.getProgress(requireContext(), 1)
            val sub2 = userData.getProgress(requireContext(), 2)
            val sub3 = userData.getProgress(requireContext(), 3)
            val sub4 = userData.getProgress(requireContext(), 4)

            val text1: TextView = view.findViewById(R.id.sub1_progress)
            val text2: TextView = view.findViewById(R.id.sub2_progress)
            val text3: TextView = view.findViewById(R.id.sub3_progress)
            val text4: TextView = view.findViewById(R.id.sub4_progress)

            val progress1: ProgressBar = view.findViewById(R.id.progressBar1)
            val progress2: ProgressBar = view.findViewById(R.id.progressBar2)
            val progress3: ProgressBar = view.findViewById(R.id.progressBar3)
            val progress4: ProgressBar = view.findViewById(R.id.progressBar4)

            text1.text = (sub1 * 100).toString() + "%"
            text2.text = (sub2 * 100).toString() + "%"
            text3.text = (sub3 * 100).toString() + "%"
            text4.text = (sub4 * 100).toString() + "%"

            progress1.progress = (sub1 * 100).toInt()
            progress2.progress = (sub2 * 100).toInt()
            progress3.progress = (sub3 * 100).toInt()
            progress4.progress = (sub4 * 100).toInt()

        }
    }

}