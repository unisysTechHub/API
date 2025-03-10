package com.example.api

import android.util.Log
import com.example.api.resposne.Account
import com.example.api.transfersRepo.Result
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


//suspend fun <T> awaitCallback(api: TransfersUsecase): T = suspendCancellableCoroutine { continuation ->
//    val callback = object : Callback<T> {
//        override fun onCompleted(value: T) {
//            continuation.resume(value)
//        }
//
//        override fun onApiError(cause: Throwable) {
//            continuation.resumeWithException(cause)
//        }
//
//        override fun onApiError(message: String) {
//            TODO("Not yet implemented")
//        }
//    }
//   api.getAccounts()
//
//}
//
//interface Api<T> {
//    fun register(callback: Callback<T>)
//    fun unregister(callback: Callback<T>)
//}

// Define the Callback interface
interface Callback<T> {
    fun onCompleted(value: T)
    fun onApiError(message: String)
}

// Example implementation of the API
//class ApiImpl<T> : Api<T> {
//    private val callbacks = mutableListOf<Callback<T>>()
//
//    override fun register(callback: Callback<T>) {
//        callbacks.add(callback)
//        // Simulate an operation
//        simulateApiCall(callback)
//    }
//
//    override fun unregister(callback: Callback<T>) {
//        callbacks.remove(callback)
//    }
//}
