package com.brunadev.bookstore.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunadev.bookstore.data.Book
import com.brunadev.bookstore.databinding.ActivityMainBinding
import com.brunadev.bookstore.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private var listSize: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.init()
        setObservers()

        binding.viewModel = viewModel

        rvlist.layoutManager = LinearLayoutManager(this@MainActivity)


        binding.fabDialog.setOnClickListener {
            if (listSize > 0) {
                Toast.makeText(this, "$listSize books available now", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setObservers() {

        viewModel.listState.observe(this@MainActivity) { bookList ->
            binding.shimmerList.startShimmer()
            binding.shimmerList.isShimmerVisible

            if (bookList?.resultsList?.isNotEmpty() == true) {
                binding.shimmerList.visibility = View.GONE
                binding.shimmerList.stopShimmer()
                rvlist.visibility = View.VISIBLE
                showProjects(bookList.resultsList)
                listSize = bookList.resultsList.size
            }else{
                binding.shimmerList.visibility = View.GONE
                binding.shimmerList.stopShimmer()
                binding.txtNotFound.visibility = View.VISIBLE
            }
        }
    }

    private fun showProjects(list: List<Book>) {

        if (list.isNotEmpty()) {
            rvlist.adapter = ListBookAdapter(list) { item ->
                setDetailView(item)
            }
        }
    }

    private fun setDetailView(item: Book) {

        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.BOOK_DTO, item)
        }
        startActivity(intent)
    }

}

