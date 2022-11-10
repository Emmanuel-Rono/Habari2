package mvvmApp.api

import mvvmApp.models.NewsResponse
import mvvmApp.ui.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
//This interface defines how, retrofit talks to the web server using
//HTTP request

interface newsApi
{
    //To get all the breaking news from the API
    //use get to tell Retrofit tht this is a get request and
    // specifiy an endpoint ** v2/top-headlines
    // When the  * getBreakingNews() method is invoked,
    // Retrofit appends the endpoint photos to the base URL
    @GET("v2/top-headlines")
    suspend fun getBreakingnews(
        @Query("country")
        countrycode:String="us",
        @Query("page")
    pageNumber:Int =1,
        @Query("apiKey")
        apiKey:String=API_KEY
    ):Response<NewsResponse>
    //Above function should return A RESPONSE OF TYPE NewsResponse

    //To get all the breaking news from the API
    @GET("v2/everything")
    suspend fun searchnews(
        @Query("q")
        searchquery:String,
        @Query("page")
        pageNumber:Int =1,
        @Query("apiKey")
        apiKey:String=API_KEY
    ):Response<NewsResponse>
    //Above function should return A RESPONSE OF TYPE NewsResponse


}