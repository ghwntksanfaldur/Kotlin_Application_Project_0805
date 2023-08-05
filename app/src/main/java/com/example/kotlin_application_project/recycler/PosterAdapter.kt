package com.example.kotlin_application_project.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_application_project.R
import com.example.kotlin_application_project.databinding.ItemPosterBinding
import com.example.kotlin_application_project.model.Poster
import com.squareup.picasso.Picasso // 이미지 로딩 라이브러리

class PosterViewHolder(val binding: ItemPosterBinding): RecyclerView.ViewHolder(binding.root)

class PosterAdapter(private val posters: List<Poster>) :
    RecyclerView.Adapter<PosterAdapter.PosterViewHolder>() {

    inner class PosterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_poster, parent, false)
        return PosterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val currentPoster = posters[position]
        holder.titleTextView.text = currentPoster.title
        holder.dateTextView.text = currentPoster.date
        holder.locationTextView.text = currentPoster.location
//        Picasso.get().load(currentPoster.imageUrl).into(holder.imageView)

    }

    override fun getItemCount() = posters.size
}
