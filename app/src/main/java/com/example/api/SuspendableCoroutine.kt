package com.example.api

import android.util.Log
import com.example.api.resposne.Account
import com.example.api.transfersRepo.Result
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


// Define the Callback interface
interface Callback<T> {
    fun onCompleted(value: T)
    fun onApiError(message: String)
}

