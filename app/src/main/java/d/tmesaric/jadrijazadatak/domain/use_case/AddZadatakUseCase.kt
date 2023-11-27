package d.tmesaric.jadrijazadatak.domain.use_case

import android.util.Log
import d.tmesaric.jadrijazadatak.domain.model.InvalidZadatakException
import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.domain.repository.ZadatakRepository

class AddZadatakUseCase(
    private val repository: ZadatakRepository
) {

    @Throws(InvalidZadatakException::class)
    suspend operator fun invoke(zadatak: Zadatak) {
        if(zadatak.title.isBlank()){
            throw InvalidZadatakException("Zadatak name can not be empty")
        }

        if (zadatak.content.isBlank()){
            throw InvalidZadatakException("Zadatak content can not be empty")

        }
        repository.insertZadatak(zadatak)
    }
}