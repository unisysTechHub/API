package com.example.api.request

import com.example.api.resposne.Account
import java.math.BigDecimal

data class FundTransferRequestModel(
    val senderAccount: String? = null,
    val senderAccountType: String? = null,
    val receiverAccount: String? = null,
    val receiverAccountType: String? = null,
    val amount: BigDecimal? = null,
    val transactionType: String? = null,
    val transferType: String? = null,
    val senderAccountDetails: Account? = null,
    val receiverAccountDetails: Account? = null,
    val beneficiary: BeneficiaryModel? = null,
    val description: String? = null

)