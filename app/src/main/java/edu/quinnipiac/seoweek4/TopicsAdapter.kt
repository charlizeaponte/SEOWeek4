package edu.quinnipiac.seoweek4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TopicsAdapter(private val topics: List<String>, private val images: List<Int>) : RecyclerView.Adapter<TopicsAdapter.TopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.topicTextView.text = topics[position]
        Glide.with(holder.topicImageView.context)
            .load(images[position])
            .into(holder.topicImageView)
    }

    override fun getItemCount(): Int = topics.size

    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicTextView: TextView = itemView.findViewById(R.id.topic_text)
        val topicImageView: ImageView = itemView.findViewById(R.id.topic_image)
    }
}
