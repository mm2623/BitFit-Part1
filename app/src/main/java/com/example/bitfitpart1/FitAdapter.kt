package com.example.bitfitpart1

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
private const val TAG = "ArticleAdapter"

class FitAdapter(private val context: Context, private val bitFit: MutableList<DisplayFit>) :
    RecyclerView.Adapter<FitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.all_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Get the individual article and bind to holder

        val fit = bitFit[position]
//        holder.nameTextView.text = fit.name
//        holder.caloriesTextView.text = fit.calories
        holder.bind(fit)
        // TO delete an Item
//        holder.itemView.setOnLongClickListener {
//            Log.v("on click listener","In the system")
//            Log.d("postion", position.toString())
//            Log.d("List", bitFit.toString())
//            bitFit.removeAt(position)
//            notifyItemRemoved(position)
//            notifyDataSetChanged()
//            true
//        }
    }

    override fun getItemCount() = bitFit.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView = itemView.findViewById<TextView>(R.id.Name)
        private val caloriesTextView = itemView.findViewById<TextView>(R.id.Calories)

        fun bind(fit: DisplayFit) {
            nameTextView.text = fit.name
            caloriesTextView.text = fit.calories
        }
    }
}