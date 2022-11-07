package mvvmApp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.habari2.R
import mvvmApp.ui.Breaking_News
import mvvmApp.ui.newsViewModel

class articleFragment : Fragment(R.layout.fragment_article)
{
    lateinit var viewmodel: newsViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel=(activity as Breaking_News).viewmodel
    }
}

