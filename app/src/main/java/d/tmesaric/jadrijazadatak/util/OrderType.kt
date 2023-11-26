package d.tmesaric.jadrijazadatak.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
