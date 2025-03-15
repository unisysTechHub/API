package com.example.api

import android.util.Log
import com.example.api.request.BeneficiaryModel
import com.example.api.request.FundTransferRequestModel
import com.example.api.resposne.Account
import com.example.api.resposne.AccountList
import com.example.api.resposne.json.accountAPIJSon
import com.example.api.transfersRepo.Result
import com.example.api.transfersRepo.TransfersRepo
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TransfersUsecase {
    val transfersRepo = TransfersRepo()
  val accountList: List<Account>? = Gson().fromJson(accountAPIJSon, AccountList::class.java).accountList
//    val result: Result.Success<*>
//        get() = Result.Success(data = this.filteredData(accountList.accountList!!))

    fun getAccounts(): Flow<Result> = flow {
        //  val result: Result = transfersRepo.accounts()
        val accountList: AccountList = Gson().fromJson(accountAPIJSon, AccountList::class.java)
        //   accountList.accountList?.forEach( ){ account: Account -> Log.d("@Ramesh list", account.accountNumber.toString())  }
        val result: Result = Result.Success(data = filteredData(accountList.accountList!!))
        emit(result)

    }
     fun<T> getAccounts(callback: Callback<T>): Unit  {
        //  val result: Result = transfersRepo.accounts()
        val accountList: AccountList = Gson().fromJson(accountAPIJSon, AccountList::class.java)

        accountList.accountList?.forEach( ){ account: Account -> Log.d("@Ramesh list", account.accountNumber.toString())  }
        val result : Result = Result.Success(data = listOf(AccountModel(accountNumber = "23232", accountType = "Checking", bankName = "ABC Bank")))

        when (result) {
            is Result.Error -> callback.onApiError(result.message)
            is Result.Success<*> -> {
                val accountNumber: String =
                    (result as Result.Success<List<Account>>).data[0].accountNumber!!
                Log.d(
                    "@Ramesh ",
                    (result as Result.Success<List<Account>>).data[0].usBankAccount?.bankName!!
                )
                Log.d(
                    "@Ramesh ",
                    (result as Result.Success<List<Account>>).data[0].usBankAccount?.accountType!!
                )
                callback.onCompleted((result as Result.Success<T>).data)
            }
        }
    }
    fun addBeneficiary(beneficiaryModel: BeneficiaryModel) : Flow<Result> = flow {
            val result : Result = transfersRepo.addBeneficiary(beneficiaryModel)
            when(result){
                is Result.Error -> emit(result)
                is Result.Success<*> -> {
                    emit(result)
                }
            }

    }
    fun getBeneficiariesList() = flow<Result> {
        // update cache
       emit (transfersRepo.beneficiariesList())
    }
    fun initTransfer(model : FundTransferRequestModel){

    }
    val filteredData :(List<Account>) -> List<AccountModel> = { accounts ->
        accounts.filter { account ->
            account.accountId != null &&
                    account.usBankAccount?.let { it.bankName != null && it.accountType != null } == true
        }
            .map { account ->
                account.usBankAccount!!.let {
                    Log.d("@Ramesh map", account.accountNumber!! + it.bankName!!+ it.accountType!!)
                    AccountModel(
                        accountNumber = account.accountNumber!!,
                        bankName = it.bankName!!,
                        accountType = it.accountType!!
                    )
                }
            }
    }
}