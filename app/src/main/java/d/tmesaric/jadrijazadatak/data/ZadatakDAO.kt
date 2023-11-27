package d.tmesaric.jadrijazadatak.data

import androidx.room.*
import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import kotlinx.coroutines.flow.Flow

@Dao
interface ZadatakDAO {

    @Upsert
    suspend fun insertZadatak(zadatak: Zadatak)

    @Delete
    suspend fun deleteZadatak(zadatak: Zadatak)

    @Query("SELECT * FROM zadatak")
    fun getZadaci(): Flow<List<Zadatak>>

    @Query("SELECT * FROM zadatak WHERE id = :id")
    suspend fun getZadatakById(id: Int): Zadatak?
}