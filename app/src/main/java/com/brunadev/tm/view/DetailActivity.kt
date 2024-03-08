package com.brunadev.tm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import com.brunadev.tm.databinding.ActivityDetailBinding
import com.brunadev.tm.model.Events
import com.brunadev.tm.utils.UtilDateFormat
import com.brunadev.tm.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.img_event
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EVENT_DTO = "EVENT_DTO"
    }

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        receiveIntent()
        observeData()
    }

    private fun receiveIntent() {

        val eventSelected = intent.getParcelableExtra<Events?>(EVENT_DTO)
        eventSelected?.let { viewModel.setBookDetail(it) }
    }

    private fun observeData() {

        viewModel.bookDetail.observe(this@DetailActivity) {
            setDetailData(it)
        }
    }

    private fun setDetailData(eventSelected: Events) {

        binding.eventTitle.text = eventSelected.name
        val data = eventSelected.dates.start.localDate
        binding.eventData.text = DateFormat.format(
            "E MMMM dd,yyyy hh:mm a",
            data?.let { UtilDateFormat().dateFormat(it) }
        )
        binding.eventLocation.text =
            eventSelected.classifications.map { it.segment.name }.toString()
        binding.eventType.text = eventSelected.classifications.map { it.genre.name }.toString()
        val img = eventSelected.images[0].url
        Picasso.get().load(img).into(img_event)
    }
}

