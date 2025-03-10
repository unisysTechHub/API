package com.example.api.resposne

import com.example.api.request.BeneficiaryModel


class AccountList : BaseResponse() {
    var accountList: List<Account>? = null
}

class AddBeneficiary:BaseResponse(){
    var addBeneficiary: BeneficiaryModel?=null
}
