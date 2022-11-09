package mvvmApp.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.habari2.R
import mvvmApp.Adapters.NewsAdapter
import mvvmApp.NewsActivity
import mvvmApp.util.Resource

class
Breaking_News : Fragment(R.layout.fragment_breaking_news)
{
    lateinit var viewmodel:newsViewModel
    lateinit var newsAdapter:NewsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel=(activity as NewsActivity).viewModel
        setupRecyclerview()
        viewmodel.breakingNews.observe(viewLifecycleOwner, Observer { response
        -> when(response){
            is Resource.Success ->{
                hideProgressBar()
            }
            else -> {
                showprogressbar()
                //Toast.makeText(this,"An error Ocurred", Toast.LENGTH_LONG).Show()
            }
        }
        })


    }
    fun setupRecyclerview() {
        newsAdapter=NewsAdapter()
        val recyclerView= view?.findViewById<RecyclerView>(R.id.rvBreaking_news)
        recyclerView?.apply {
            adapter=newsAdapter
            layoutManager=LinearLayoutManager(activity)
        }

    }
    fun hideProgressBar()
    {
        val progressBar= view?.findViewById<ProgressBar>(R.id.progressBar)
        if (progressBar != null) {
            progressBar.visibility=View.INVISIBLE
        }
    }
    fun showprogressbar()
    {
    val progressBar= view?.findViewById<ProgressBar>(R.id.progressBar)
        if (progressBar != null) {
            progressBar.visibility=View.INVISIBLE
        }
}

}