package d.tmesaric.jadrijazadatak.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import d.tmesaric.jadrijazadatak.domain.use_case.ZadatakUseCases
import d.tmesaric.jadrijazadatak.util.OrderType
import d.tmesaric.jadrijazadatak.util.ZadatakOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ZadatakViewModel @Inject constructor(
    private val zadatakUseCases: ZadatakUseCases
) : ViewModel() {

    private val _state = MutableStateFlow<ZadatakState>(ZadatakState())
    val state: StateFlow<ZadatakState> get() = _state.asStateFlow()

    private var getZadaciJob: Job? = null

    init {
        getZadaci(ZadatakOrder.Date(OrderType.Descending))
    }
    fun onEvent(event: ZadatakEvent) {
        when (event) {
            is ZadatakEvent.Order -> {
                if (state.value.zadatakOrder::class == event.zadatakOrder::class &&
                    state.value.zadatakOrder.orderType == event.zadatakOrder.orderType
                ) {
                    return
                }

                getZadaci(event.zadatakOrder)
            }

            is ZadatakEvent.AddZadatak -> {
                viewModelScope.launch {
                    zadatakUseCases.addZadatakUseCase(event.zadatak)
                }
            }

            is ZadatakEvent.DeleteZadatak -> {
                viewModelScope.launch {
                    zadatakUseCases.deleteZadatakUseCase(event.zadatak)
                }
            }

            is ZadatakEvent.CompleteZadatak -> {
                _state.value = state.value.copy(
                    isComplete = !state.value.isComplete
                )
            }
        }
    }

    private fun getZadaci(zadatakOrder: ZadatakOrder) {
        getZadaciJob?.cancel()
        zadatakUseCases.getZadaciUseCase(zadatakOrder)
            .onEach { zadaci ->
                _state.value = state.value.copy(
                    zadaci = zadaci,
                    zadatakOrder = zadatakOrder
                )
            }
            .launchIn(viewModelScope)
    }
}