package mvvmApp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mvvmApp.repositories.NewsRepository

class newsViewModelProviderFactory(val newsRepository : NewsRepository
):ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return newsViewModel(newsRepository) as T
    }

}