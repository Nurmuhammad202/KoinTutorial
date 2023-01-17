package uz.personal.kointutorial.remote

import retrofit2.Response
import retrofit2.http.GET
import uz.personal.data.remote.model.post.Post

interface ApiInterface {
    @GET("posts")
    suspend fun post(): Response<Post>
}