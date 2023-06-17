package com.brunadev.bookstore.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import com.brunadev.bookstore.data.Book
import com.brunadev.bookstore.databinding.ActivityDetailBinding
import com.brunadev.bookstore.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val BOOK_DTO = "BOOK_DTO"
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

        val bookSelected = intent.getParcelableExtra<Book>(BOOK_DTO)
        viewModel.setBookDetail(bookSelected)
    }

    private fun observeData() {

        viewModel.bookDetail.observe(this@DetailActivity){
            it?.let { setDetailData(it) }
        }
    }

    private fun setDetailData(bookSelected: Book) {

        binding.bookTitle.text = bookSelected.title
        binding.authorName.text = bookSelected.authors.map { it.name }.toString()
        binding.authorBirth.text = bookSelected.authors.map { it.birthYear}.toString()
        binding.authorDeath.text = bookSelected.authors.map { it.deathYear }.toString()
    }
}