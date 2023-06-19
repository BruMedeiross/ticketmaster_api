package com.brunadev.bookstore.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunadev.bookstore.data.Book
import com.brunadev.bookstore.databinding.ActivityMainBinding
import com.brunadev.bookstore.extension.hideKeyboard
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

        setObservers()

        binding.viewModel = viewModel

        rvlist.layoutManager = LinearLayoutManager(this@MainActivity)


        binding.fabDialog.setOnClickListener {
            if (listSize > 0) {
                Toast.makeText(this, "$listSize books available now", Toast.LENGTH_SHORT).show()
            }
        }

        binding.searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let {
                        if (it.length >= 5) {
                            viewModel.searchBook(it)
                        } else if(it.isEmpty()){
                            setObservers()
                        }
                        return true
                    }
                    return false
                }
            })
        }

    }

    private fun setObservers() {

        viewModel.init()

        viewModel.listState.observe(this@MainActivity) { bookList ->
            binding.shimmerList.startShimmer()
            binding.shimmerList.isShimmerVisible
            hideKeyboard()

            if (bookList?.resultList?.isNotEmpty() == true) {
                binding.shimmerList.visibility = View.GONE
                binding.shimmerList.stopShimmer()
                rvlist.visibility = View.VISIBLE
                binding.txtNotFound.visibility = View.GONE
                listSize = bookList.resultList.size
                showProjects(bookList.resultList)
            } else {
                binding.shimmerList.visibility = View.GONE
                binding.shimmerList.stopShimmer()
                binding.txtNotFound.visibility = View.VISIBLE
                rvlist.visibility = View.GONE
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

