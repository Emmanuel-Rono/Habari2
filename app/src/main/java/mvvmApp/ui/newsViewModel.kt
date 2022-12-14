package mvvmApp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mvvmApp.models.NewsResponse
import mvvmApp.repositories.NewsRepository
import mvvmApp.util.Resource
import retrofit2.Response

class newsViewModel( val newsRepository: NewsRepository
): ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val newsPage = 1
    fun getBreakingNews(countrycode: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countrycode, newsPage)
        breakingNews.postValue(handleBreakingNews(response))
    }
    private fun handleBreakingNews(response: Response<NewsResponse>) :Resource<NewsResponse>{
        if (response.isSuccessful) {
            response.body()?.let { resultresponse ->
                return Resource.Success(resultresponse)
            }
        }
        return Resource.Error(response.message())
    }

}

