package mvvmApp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.habari2.R

class
Breaking_News : Fragment(R.layout.fragment_breaking_news)
{
    lateinit var viewmodel:newsViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel=(activity as Breaking_News).viewmodel
    }
}