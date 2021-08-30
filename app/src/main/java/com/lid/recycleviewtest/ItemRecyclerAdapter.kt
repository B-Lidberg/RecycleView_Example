package com.lid.recycleviewtest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemRecyclerAdapter(private val list: List<Int>
) : RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemRecyclerAdapter.ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.textView.text = currentItem.toString()

        holder.itemView.setOnClickListener {
            FakeData.sortedList[position] = 
            holder.textView.text = (currentItem + 1).toString()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}