package com.example.api.resposne.json

val accountAPIJSon = """
{
    "responseCode": "200",
    "message": "User validation  sucessfull",
    "accountList": [
        {
            "accountId": 9,
            "accountNumber": "24434343435",
            "billingDetails": {
                "address": {
                    "city": "VSKP",
                    "country": "IN",
                    "line1": null,
                    "line2": null,
                    "postalCode": null,
                    "state": null
                },
                "email": "nulltest@xtc.com",
                "name": "John Doe",
                "phone": null
            },
            "usBankAccount": {
                "fingerprint": "LstWJFsCK7P349Bg",
                "last4": "6789",
                "routingNumber": null,
                "networks": {
                    "preferred": "ach",
                    "supported": "ach"
                },
                "account_holder_type": "individual",
                "account_type": "checking",
                "bank_name": "STRIPE TEST BANK",
                "financial_connections_account": null
            },
            "type": null,
            "created": null
        },
        {
            "accountId": 10,
            "accountNumber": "24434343436",
            "billingDetails": {
                "address": {
                    "city": "VSKP",
                    "country": "IN",
                    "line1": null,
                    "line2": null,
                    "postalCode": null,
                    "state": null
                },
                "email": "nulltest@xtc.com",
                "name": "John Doe",
                "phone": null
            },
            "usBankAccount": {
                "fingerprint": "LstWJFsCK7P349Bg",
                "last4": "6789",
                "routingNumber": null,
                "networks": {
                    "preferred": "ach",
                    "supported": "ach"
                },
                "account_holder_type": "individual",
                "account_type": "checking",
                "bank_name": "STRIPE TEST BANK",
                "financial_connections_account": null
            },
            "type": null,
            "created": null
        }
    ]
}
"""