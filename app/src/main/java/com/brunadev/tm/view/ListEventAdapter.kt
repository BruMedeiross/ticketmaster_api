package com.brunadev.tm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brunadev.tm.R
import com.brunadev.tm.model.Events
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.event_item.view.*

class ListEventAdapter(private val listEvents: List<Events>, val onClick: (Events) -> Unit) :
    RecyclerView.Adapter<ListEventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder =
        EventViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.event_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = listEvents.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(listEvents[position])
    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(list: Events) {
            with(itemView) {
                setOnClickListener {
                    onClick.invoke(list)
                }

                val img = list.images[0].url
                Picasso.get().load(img).into(img_event)

                name_event.text = list.name
                dates_event.text = list.dates.start.localDate
                local_event.text = list.classifications.map { it.segment.name }.toString()
                city_event.text = list.dates.timezone
            }
        }
    }
}
