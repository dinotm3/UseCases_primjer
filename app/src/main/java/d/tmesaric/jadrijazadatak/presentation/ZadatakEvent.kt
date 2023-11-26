package d.tmesaric.jadrijazadatak.presentation

import d.tmesaric.jadrijazadatak.domain.model.Zadatak
import d.tmesaric.jadrijazadatak.util.ZadatakOrder

sealed class ZadatakEvent {
    data class Order(val zadatakOrder: ZadatakOrder): ZadatakEvent()
    data class DeleteZadatak(val zadatak: Zadatak): ZadatakEvent()
    data class AddZadatak(val zadatak: Zadatak): ZadatakEvent()
    object CompleteZadatak: ZadatakEvent()

}
