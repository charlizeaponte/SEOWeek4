package edu.quinnipiac.seoweek4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class TopicsAdapter(
    private val topics: List<String>,
    private val topicImages: List<Int>,
    private val onItemClick: (String, Int) -> Unit
) : RecyclerView.Adapter<TopicsAdapter.TopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topics[position]
        val imageResId = topicImages[position]
        holder.bind(topic, imageResId, onItemClick)
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val topicImageView: ImageView = itemView.findViewById(R.id.item_image)
        private val topicTextView: TextView = itemView.findViewById(R.id.words)

        fun bind(topic: String, imageResId: Int, onItemClick: (String, Int) -> Unit) {
            Glide.with(itemView.context)
                .load(imageResId)
                .override(500, 300) // Resize the image to a maximum width and height
                .fitCenter() // Ensure the image fits well within the specified dimensions
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(topicImageView)

            topicTextView.text = topic
            itemView.setOnClickListener {
                onItemClick(topic, imageResId)
            }
        }
    }
}

