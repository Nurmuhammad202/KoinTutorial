package uz.personal.kointutorial.remote.retrofitBuilder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.personal.kointutorial.remote.ApiInterface

class RetrofitBuilder {

    companion object {
        fun retrofitBuilder(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(Companion.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}