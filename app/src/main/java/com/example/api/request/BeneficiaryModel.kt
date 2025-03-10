package com.example.api.request

data class BeneficiaryModel(
    var accountNumber: String = "",
    var bankName: String = "",
    var beneficiaryName: String = "",
    var accountType: String = "",
    var transferType: String = "",
    var transferTypeACH: String = "",
    var phoneNumber: String = "",
    var email: String = "",
    var country: String = "US",
    var currency: String = "usd",
    var iban: String = "",
    var swiftBicCode: String = ""
)