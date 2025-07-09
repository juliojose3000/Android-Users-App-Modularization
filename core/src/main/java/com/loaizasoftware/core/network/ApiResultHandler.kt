package com.loaizasoftware.core.network

import retrofit2.Response

/**
 * Utility class for handling Retrofit API responses and converting them into Kotlin [Result] types.
 * Use this class to wrap API calls and maintain consistent error handling across the data layer.
 */

class ApiResultHandler {

    companion object {

        /**
         * Executes a suspend function and wraps its result in a [Result] object.
         *
         * Use this for suspend functions that don't return a Retrofit [Response] but a plain object.
         *
         * @param apiCall A suspend lambda that performs the API call.
         * @return [Result.success] if the call succeeds, [Result.failure] if an exception occurs.
         */
        suspend fun <T> resolve(apiCall: suspend () -> T): Result<T> {
            return try {
                val response = apiCall()
                Result.success(response)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }

        /**
         * Evaluates a Retrofit [Response] and converts it into a Kotlin [Result].
         *
         * Use this when the API function returns a `Response<T>` directly.
         *
         * @param response The Retrofit [Response] to handle.
         * @return
         * - [Result.success] with the response body if the call was successful and body is not null.
         * - [Result.failure] with an exception if the response was unsuccessful or body is null.
         */
        fun <T> resolve(response: Response<T>): Result<T> {
            return try {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        Result.success(body)
                    } else {
                        Result.failure(Exception("Response body is null"))
                    }
                } else {
                    Result.failure(Exception("HTTP ${response.code()} - ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
