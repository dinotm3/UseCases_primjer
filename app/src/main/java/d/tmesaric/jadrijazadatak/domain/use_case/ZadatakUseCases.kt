package d.tmesaric.jadrijazadatak.domain.use_case

data class ZadatakUseCases(
    val getZadaciUseCase: GetZadaciUseCase,
    val deleteZadatakUseCase: DeleteZadatakUseCase,
    val addZadatakUseCase: AddZadatakUseCase
)