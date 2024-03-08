package com.brunadev.tm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunadev.tm.databinding.ActivityMainBinding
import com.brunadev.tm.extension.hideKeyboard
import com.brunadev.tm.model.Events
import com.brunadev.tm.viewmodel.MainViewModel
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

        binding.viewModel = viewModel
        binding.rvlist.layoutManager = LinearLayoutManager(this@MainActivity)

        setObservers()

        binding.searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let {
                        if (it.length >= 5) {
                            viewModel.searchEvent(it)
                        } else if (it.isEmpty()) {
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

        viewModel.listState.observe(this@MainActivity) { event ->
            val listEvents = event?.Embedded?.events
            rvlist.visibility = View.GONE
            binding.shimmerList.startShimmer()
            binding.shimmerList.isShimmerVisible
            hideKeyboard()

            if (listEvents != null) {
                binding.shimmerList.visibility = View.GONE
                binding.shimmerList.stopShimmer()
                rvlist.visibility = View.VISIBLE
                binding.txtNotFound.visibility = View.GONE
                showProjects(listEvents)
            } else {
                binding.shimmerList.visibility = View.GONE
                binding.shimmerList.stopShimmer()
                binding.txtNotFound.visibility = View.VISIBLE
                rvlist.visibility = View.GONE
            }
        }
    }

    private fun showProjects(list: List<Events>) {

        if (list.isNotEmpty()) {
            rvlist.adapter = ListEventAdapter(list) { item ->
                setDetailView(item)
            }
        }
    }

    private fun setDetailView(item: Events) {

        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EVENT_DTO, item)
        }
        startActivity(intent)
    }

}

