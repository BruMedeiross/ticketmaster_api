package com.brunadev.tm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brunadev.tm.databinding.FragmentDetailBinding

const val EVENT_NAME = "event_name"
const val EVENT_DATE = "event_date"
const val EVENT_TYPE = "event_type"
const val EVENT_IMAGE_URL = "event_image_url"
const val EVENT_GENRE = "event_genre"
class DetailFragment : Fragment() {
    private var eventName: String? = null
    private var eventDate: String? = null
    private var eventType: String? = null
    private var eventImage: String? = null
    private var eventGenre: String? = null
    lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}