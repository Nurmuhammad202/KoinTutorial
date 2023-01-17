package uz.personal.kointutorial.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.personal.kointutorial.room.model.UserLocal

@Dao
interface RoomInterface {

    @Insert
    suspend fun saveUser(userLocal: UserLocal)

    @Query("SELECT * FROM user_local")
    suspend fun getUser(): List<UserLocal>
}