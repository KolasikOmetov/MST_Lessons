package com.nodj.readmelater.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.nodj.readmelater.data.model.Page
import com.nodj.readmelater.R
import com.nodj.readmelater.ui.main.adapter.MainAdapter.DataViewHolder
import kotlinx.android.synthetic.main.item_layout.view.textViewPageName
import kotlinx.android.synthetic.main.item_layout.view.textViewPageUrl
import kotlinx.android.synthetic.main.item_layout.view.imageViewPage

class MainAdapter(private val pages: ArrayList<Page>) : RecyclerView.Adapter<DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(page: Page) {
            itemView.apply {
                textViewPageName.text = page.name
                textViewPageUrl.text = page.url
//                Glide.with(imageViewPage.context)
//                    .load(page.image)
//                    .into(imageViewPage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = pages.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(pages[position])
    }

    fun addPages(users: List<Page>) {
        this.pages.apply {
            clear()
            addAll(users)
        }

    }
}