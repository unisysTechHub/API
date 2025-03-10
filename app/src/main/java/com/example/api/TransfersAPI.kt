package com.example.api

import android.util.Log
import com.example.api.request.BeneficiaryModel
import com.example.api.resposne.AccountList
import com.example.api.resposne.AddBeneficiaryResponse
import com.example.api.resposne.BeneficiariesListResponse
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

const val baseURL = "https://w41v53pmwj.execute-api.us-east-1.amazonaws.com/default/"
interface TransfersAPI {

    @POST("api/user/accounts")
    suspend  fun accounts(@HeaderMap headers: Map<String,String>, @Body body: accuntRequestBody) : AccountList

    @POST("api/transfer/addBeneficiary")
    suspend fun addBeneficiary(@HeaderMap headers: Map<String,String>, @Body body: BeneficiaryModel) : AddBeneficiaryResponse

    @POST("api/transfer/beneficiaries")
    suspend fun beneficiariesList(@HeaderMap headers: Map<String,String>, @Body body: accuntRequestBody) : BeneficiariesListResponse

    data class accuntRequestBody(val userId: String, val password : String)   {
    }
    companion object {
//        private const val BASE_URL = "https://w41v53pmwj.execute-api.us-east-1.amazonaws.com/default/"
 private const val BASE_URL = "http://10.0.2.2:8082/"
        fun create(): TransfersAPI {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Log.d("API", it) })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL.toHttpUrlOrNull()!!)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TransfersAPI::class.java)
        }
    }
}