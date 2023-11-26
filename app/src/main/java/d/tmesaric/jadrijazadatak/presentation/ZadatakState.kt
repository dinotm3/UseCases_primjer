package d.tmesaric.jadrijazadatak.presentation

import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.util.OrderType
import d.tmesaric.jadrijazadatak.util.ZadatakOrder

data class ZadatakState(
    val zadaci: List<Zadatak> = emptyList(),
    val zadatakOrder: ZadatakOrder = ZadatakOrder.Date(OrderType.Descending),
    val isComplete: Boolean = false
)
