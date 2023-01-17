package uz.personal.kointutorial.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_local")
class UserLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var surname: String
){
    constructor():this(0,"")
}