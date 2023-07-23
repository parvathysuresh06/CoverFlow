package com.example.coverflow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoverFlowAdapter(private val dataList: List<CoverData>) :
    RecyclerView.Adapter<CoverFlowAdapter.ViewHolder>() {
    private var textDirection: Int = View.TEXT_DIRECTION_RTL
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
holder.bind(data)


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setTextDirection(direction: Int) {
        textDirection = direction
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textViewName)
        private val textViewValue: TextView = itemView.findViewById(R.id.textViewTwo)

        fun bind(data: CoverData) {
textView.text=data.text
            textViewValue.text = data.textTwo
        }
        // Declare your ViewHolder views and bind them in the onCreateViewHolder() method
    }
}
