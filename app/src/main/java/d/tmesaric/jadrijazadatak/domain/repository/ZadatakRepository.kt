package d.tmesaric.jadrijazadatak.domain.repository

import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import kotlinx.coroutines.flow.Flow

interface ZadatakRepository {

    fun getZadaci(): Flow<List<Zadatak>>

    suspend fun getZadatakById(id: Int): Zadatak?

    suspend fun insertZadatak(zadatak: Zadatak)

    suspend fun deleteZadatak(zadatak: Zadatak)
}