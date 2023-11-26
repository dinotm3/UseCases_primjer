package d.tmesaric.jadrijazadatak.data.repository

import d.tmesaric.jadrijazadatak.data.ZadatakDAO
import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.domain.repository.ZadatakRepository
import kotlinx.coroutines.flow.Flow

class ZadatakRepositoryImpl(
    private val dao: ZadatakDAO
): ZadatakRepository {
    override fun getZadaci(): Flow<List<Zadatak>> {
        return dao.getZadaci()
    }

    override suspend fun getZadatakById(id: Int): Zadatak? {
        return dao.getZadatakById(id)
    }

    override suspend fun insertZadatak(zadatak: Zadatak) {
        return dao.insertZadatak(zadatak)
    }

    override suspend fun deleteZadatak(zadatak: Zadatak) {
        return dao.deleteZadatak(zadatak)
    }
}