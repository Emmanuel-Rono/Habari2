package mvvmApp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.habari2.R


class Search_News : Fragment(R.layout.fragment_search_news) {

    lateinit var viewmodel:newsViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel=(activity as Breaking_News).viewmodel
    }

    }

