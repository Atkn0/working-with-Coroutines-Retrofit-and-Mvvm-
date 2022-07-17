package com.example.kotlinroom.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinroom.Model.PhotoModel
import com.example.kotlinroom.databinding.ActivityMainBinding
import com.example.kotlinroom.databinding.RecyclerCardsBinding
import com.squareup.picasso.Picasso

class HomeRecyclerViewAdapter(val Photolist:List<PhotoModel>) : RecyclerView.Adapter<HomeRecyclerViewAdapter.myViewHolder>(){

    class myViewHolder(val binding: RecyclerCardsBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding = RecyclerCardsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Photolist.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.binding.RecyclerTextView.text = Photolist[position].title
        Picasso.get().load(Photolist[position].url).into(holder.binding.RecyclerImageView)

    }
}