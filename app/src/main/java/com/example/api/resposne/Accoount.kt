package com.example.api.resposne

import com.google.gson.annotations.SerializedName


data class Account(var accountId: Long? = null,

                   var accountNumber: String? = null,

                   var billingDetails: BillingDetails? = null,

                   var usBankAccount: UsBankAccount? = null,

                   var type: String? = null,

                   var created: Long? = null,
) {


    class BillingDetails {
        var address: Address? = null

        var email: String? = null

        var name: String? = null

        var phone: String? = null

        class Address {
            var city: String? = null

            var country: String? = null

            var line1: String? = null

            var line2: String? = null

            var postalCode: String? = null

            // Getters and Setters
            var state: String? = null

        } // Getters and Setters
    }

    class UsBankAccount {

        var accountHolderType: String? = null

       @SerializedName("account_type")
        var accountType: String? = null

        @SerializedName("bank_name")
        var bankName: String? = null


        var financialConnectionsAccount: String? = null


        var fingerprint: String? = null


        var last4: String? = null


        var routingNumber: String? = null

        var networks: Networks? = null

        class Networks {
            var preferred: String? = null

            // Getters and Setters
            var supported: String? = null

        } // Getters and Setters
    } // Other fields ...
    // Getters and Setters
}

