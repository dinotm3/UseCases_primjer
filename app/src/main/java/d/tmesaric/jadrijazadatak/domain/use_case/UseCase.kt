package d.tmesaric.jadrijazadatak.domain.use_case

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

abstract class UseCase<in Params, out T> {

    abstract suspend fun run(params: Params): Result<T>

    suspend operator fun invoke(params: Params): Result<T> {
        return try {
            run(params)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
