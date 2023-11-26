package d.tmesaric.jadrijazadatak.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Zadatak(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val content: String,
    val timestamp: Long,
    val isComplete: Boolean = false
)

class InvalidZadatakException(message: String): Exception(message)