package uz.personal.kointutorial.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import uz.personal.data.remote.model.post.Post
import uz.personal.kointutorial.repository.NetworkRepository
import uz.personal.kointutorial.room.model.UserLocal

class MainViewModel(private val networkRepository: NetworkRepository) : ViewModel() {

    private val _postLiveData = MutableLiveData<Post>()
    val postLiveData: LiveData<Post> = _postLiveData
    fun getPost() = viewModelScope.launch {
        val response = networkRepository.getPost()
        if (responseSuccess(response)) {
            _postLiveData.value = response.body()
        }
    }

    fun saveUser(userLocal: UserLocal) = viewModelScope.launch {
        networkRepository.insertUserLocal(userLocal = userLocal)
    }

    suspend fun getUser(): List<UserLocal> = networkRepository.getUserLocal()

    private fun <T> responseSuccess(data: Response<T>): Boolean {
        return data.isSuccessful && data.code() == 200
    }
}