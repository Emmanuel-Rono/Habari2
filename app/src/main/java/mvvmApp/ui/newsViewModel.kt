package mvvmApp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mvvmApp.models.NewsResponse
import mvvmApp.repositories.NewsRepository
import mvvmApp.util.Resource

class newsViewModel( val newsRepository: NewsRepository
): ViewModel()
{

    val breakingNews :MutableLiveData<Resource<NewsResponse>> =MutableLiveData()
    val newsPage=1
    fun getBreakingNews()

}