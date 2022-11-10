package mvvmApp.api

import mvvmApp.ui.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    //Companion Object can be called without having an instanc of it
    //
    companion object {
        private val retrofit by lazy {
            //lazy ensure that this class will not be instantiated
            //Interceptors to check the current status of the network calls.
            val logging= HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            //client=Network Client
            val client = OkHttpClient.Builder()
                .addInterceptor(logging).build()
            //Builder class uses the Builder API to allow defining
            // the URL end point for the HTTP operations
            // //and finally build a new Retrofit instance.
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build()
        }
    val api by lazy{
            retrofit.create(newsApi::class.java)
        cd}
    }

}