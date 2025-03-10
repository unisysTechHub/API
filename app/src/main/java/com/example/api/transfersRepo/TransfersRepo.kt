package com.example.api.transfersRepo

import com.example.api.AccountModel
import com.example.api.TransfersAPI
import com.example.api.request.BeneficiaryModel
import com.example.api.resposne.Account
import com.example.api.resposne.AccountList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async

sealed class Result{
    class Success<T>(val data : T): Result()
    class Error(val message: String) : Result()
    object IsLoading
}
class TransfersRepo {
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    val transfersAPI by lazy { TransfersAPI.create() }

    suspend fun accounts() : Result {
        return try {
            val defferejob = scope.async { transfersAPI.accounts(headers, TransfersAPI.accuntRequestBody("user123", "")); }
            val defferejob1 = scope.async { transfersAPI.accounts(headers, TransfersAPI.accuntRequestBody("user123", "")); }
            //val x:Pair<AccountList,AccountList> =  defferejob.await() to defferejob1.await()
            val response = defferejob.await()
            if (response.responseCode == "200"){
                response.accountList?.let { it -> filteredData(it)?.let { Result.Success(it) } ?: Result.Error("")  } ?: Result.Error("Accounts List Empty")
            }else{
                Result.Error(response.message!!)
            }
        }catch (e: Exception){
            Result.Error(e.message!!)
        }
    }
    private val headers: MutableMap<String, String> = mutableMapOf<String, String>().apply {
        this["Content-Type"] = "application/json"
    }
   val filteredData :(List<Account>) -> List<AccountModel>? = { accounts ->
       accounts.filter { account ->
           account.accountId != null &&
                   account.usBankAccount?.let { it.bankName != null && it.accountType != null } == true
       }
           .map { account ->
               account.usBankAccount!!.let {
                   AccountModel(
                       accountNumber = account.accountNumber!!,
                       bankName = it.bankName!!,
                       accountType = it.accountType!!
                   )
               }
           }
   }

    suspend fun addBeneficiary(beneficiaryModel: BeneficiaryModel) : Result{
        return try {
            val deferrer = scope.async { transfersAPI.addBeneficiary(headers, beneficiaryModel) }
            val response = deferrer.await()
            if (response.responseCode == "200"){
                response.beneficiary?.let { Result.Success(it) } ?: Result.Error("Add Beneficiary Null")
            } else {
                Result.Error(response.message!!)
            }
        }catch (e:Exception){
            Result.Error(e.message!!)
        }
    }
    suspend fun beneficiariesList() : Result {
        return try {
            val defferejob = scope.async { transfersAPI.beneficiariesList(headers, TransfersAPI.accuntRequestBody("user123", "")); }

            //val x:Pair<AccountList,AccountList> =  defferejob.await() to defferejob1.await()
            val response = defferejob.await()
            if (response.responseCode == "200"){
                response.beneficiarylist?.let {  Result.Success(it) } ?: Result.Error("Beneficiaries List Empty")
            }else{
                Result.Error(response.message!!)
            }
        }catch (e: Exception){
            Result.Error(e.message!!)
        }
    }

}