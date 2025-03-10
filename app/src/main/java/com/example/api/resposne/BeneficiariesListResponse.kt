package com.example.api.resposne

import com.example.api.request.BeneficiaryModel

data class BeneficiariesListResponse(val beneficiarylist : List<BeneficiaryModel>? ) : BaseResponse()