package d.tmesaric.jadrijazadatak.domain.use_case

import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.domain.repository.ZadatakRepository

class DeleteZadatakUseCase(
    private val repository: ZadatakRepository
) : UseCase<DeleteZadatakUseCase, Unit>() {

    suspend operator fun invoke(zadatak: Zadatak) {
        repository.deleteZadatak(zadatak)
    }

    override suspend fun run(params: DeleteZadatakUseCase): Result<Unit> {
        return try {
            invoke(params)
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}