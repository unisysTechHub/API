package com.example.api.resposne.json

val beneficiariesListJSon = """
    {
        "responseCode": "200",
        "message": "List beneficiaries successful",
        "beneficiarylist": [
            {
                "accountType": "Checking",
                "transferType": "DomesticWire",
                "transferTypeACH": "",
                "country": "US",
                "currency": "usd",
                "iban": "",
                "swiftBicCode": "HDFC1234",
                "accountNumber": 123456789,
                "beneficiaryName": "Ramesh Kumar P",
                "bankName": "ABC Bank",
                "email": "fefgg@hhh.com",
                "phoneNumber": "1234556677"
            }
        ]
    }
    
""".trimIndent()