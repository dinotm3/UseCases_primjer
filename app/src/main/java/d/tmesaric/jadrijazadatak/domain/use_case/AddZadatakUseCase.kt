package d.tmesaric.jadrijazadatak.domain.use_case

import d.tmesaric.jadrijazadatak.domain.model.InvalidZadatakException
import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.domain.repository.ZadatakRepository

class AddZadatakUseCase(
    private val repository: ZadatakRepository
) {

    @Throws(InvalidZadatakException::class)
    suspend operator fun invoke(zadatak: Zadatak) {
        if(zadatak.name.isBlank()){
            throw InvalidZadatakException("Zadatak name can not be empty")
        }

        if (zadatak.content.isBlank()){
            throw InvalidZadatakException("Zadatak content can not be empty")

        }
        repository.insertZadatak(zadatak)
    }
}