package mvvmApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.habari2.R
import mvvmApp.db.ArticleDatabase
import mvvmApp.repositories.NewsRepository
import mvvmApp.ui.newsViewModel
import mvvmApp.ui.newsViewModelProviderFactory

class NewsActivity : AppCompatActivity() {
    lateinit var navController:NavController
    lateinit var viewModel: newsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        //get the repository here

        val  newsRepo=NewsRepository(ArticleDatabase(this))
        val newsViewModelprovideFactory=newsViewModelProviderFactory(newsRepo)
        viewModel= ViewModelProvider(this, newsViewModelprovideFactory)[newsViewModel::class.java]




        val navHostFragment=supportFragmentManager.findFragmentById(R.id.NavHostContainer) as NavHostFragment
        navController=navHostFragment.navController
        setupActionBarWithNavController(navController)


















    }
}