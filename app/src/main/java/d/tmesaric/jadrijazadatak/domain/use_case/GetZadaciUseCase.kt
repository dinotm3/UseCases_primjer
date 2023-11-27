package d.tmesaric.jadrijazadatak.domain.use_case

import d.tmesaric.jadrijazadatak.data.ZadatakDB
import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.domain.repository.ZadatakRepository
import d.tmesaric.jadrijazadatak.util.OrderType
import d.tmesaric.jadrijazadatak.util.ZadatakOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetZadaciUseCase(
    private val repository: ZadatakRepository
) : UseCase<GetZadaciUseCase.Params, Flow<List<Zadatak>>>() {

    data class Params(val param: String)

    operator fun invoke(
        zadatakOrder: ZadatakOrder = ZadatakOrder.Date(OrderType.Descending)
    ): Flow<List<Zadatak>> {
        return repository.getZadaci().map { zadaci ->
            when (zadatakOrder.orderType) {
                is OrderType.Ascending -> {
                    when (zadatakOrder) {
                        is ZadatakOrder.Name -> zadaci.sortedBy { it.title.lowercase() }
                        is ZadatakOrder.Date -> zadaci.sortedBy { it.timestamp }
                    }
                }

                is OrderType.Descending -> {
                    when (zadatakOrder) {
                        is ZadatakOrder.Name -> zadaci.sortedByDescending { it.title.lowercase() }
                        is ZadatakOrder.Date -> zadaci.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }

    override suspend fun run(params: Params): Result<Flow<List<Zadatak>>> {
        return try {
            val result = invoke()
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}