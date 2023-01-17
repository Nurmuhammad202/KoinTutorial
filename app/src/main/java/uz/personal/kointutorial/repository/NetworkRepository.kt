package uz.personal.kointutorial.repository

import retrofit2.Response
import uz.personal.data.remote.model.post.Post
import uz.personal.kointutorial.remote.ApiInterface
import uz.personal.kointutorial.room.RoomInterface
import uz.personal.kointutorial.room.model.UserLocal

class NetworkRepository(
    private val apiInterface: ApiInterface,
    private val roomInterface: RoomInterface
) {

    suspend fun getPost(): Response<Post> {
        return apiInterface.post()
    }

    suspend fun insertUserLocal(userLocal: UserLocal) {
        roomInterface.saveUser(userLocal)
    }

    suspend fun getUserLocal(): List<UserLocal> {
        return roomInterface.getUser()
    }
}