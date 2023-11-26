package d.tmesaric.jadrijazadatak.util

sealed class ZadatakOrder(val orderType: OrderType) {
    class Name(orderType: OrderType): ZadatakOrder(orderType)
    class Date(orderType: OrderType): ZadatakOrder(orderType)
}
