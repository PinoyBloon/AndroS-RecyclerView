package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DragonsAdapter (
    private val context: Context,
    private val dragons: List<Dragons>,
    val listener:(Dragons) -> Unit) : RecyclerView.Adapter<DragonsAdapter.DragonsViewHolder> () {

    class DragonsViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        val imgDragons = view.findViewById<ImageView>(R.id.img_item_photo)
        val nameDragons = view.findViewById<TextView>(R.id.item_name)
        val descDragons = view.findViewById<TextView>(R.id.item_description)

        fun bindView(dragons: Dragons,listener: (Dragons) -> Unit) {
            imgDragons.setImageResource(dragons.imgDragons)
            nameDragons.text = dragons.nameDragons
            descDragons.text = dragons.descDragons
            itemView.setOnClickListener{
                listener(dragons)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonsViewHolder {
        return DragonsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_dragons, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DragonsViewHolder, position: Int) {
        holder.bindView(dragons[position],listener)
    }

    override fun getItemCount(): Int = dragons.size
}