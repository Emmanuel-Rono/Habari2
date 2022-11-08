package mvvmApp.repositories

import android.provider.MediaStore.Audio.Artists
import mvvmApp.api.RetrofitInstance
import mvvmApp.db.ArticleDatabase

class NewsRepository(val database:ArticleDatabase)
 {

 suspend fun getBreakingNews(countrycode : String, pageNumber: Int )=
  RetrofitInstance.api.getBreakingnews(countrycode, pageNumber)
}