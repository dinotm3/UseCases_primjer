package d.tmesaric.jadrijazadatak.domain.use_case

import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.domain.repository.ZadatakRepository

class DeleteZadatakUseCase(
    private val repository: ZadatakRepository
) {
    suspend operator fun invoke(zadatak: Zadatak) {
        repository.deleteZadatak(zadatak)
    }
}