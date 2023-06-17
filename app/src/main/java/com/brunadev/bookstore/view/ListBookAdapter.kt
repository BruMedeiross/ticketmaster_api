package com.brunadev.bookstore.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brunadev.bookstore.R
import com.brunadev.bookstore.data.Book
import kotlinx.android.synthetic.main.book_item.view.*

class ListBookAdapter(private val listProjects: List<Book>, val onClick: (Book) -> Unit) : RecyclerView.Adapter<ListBookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.book_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = listProjects.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(listProjects[position])
    }

    fun update() {
        notifyDataSetChanged()
    }


    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(list: Book) {
            with(itemView) {
                setOnClickListener {
                    onClick.invoke(list)
                }
                name_books.text = list.title
                author_books.text = list.authors.map { it.name }.toString()
            }
        }
    }
}