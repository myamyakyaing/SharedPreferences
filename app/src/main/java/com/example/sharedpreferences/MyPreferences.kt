package com.example.sharedpreferences

import android.content.Context

class MyPreferences(context: Context) {
    private val sharedPref = context.getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE)

    companion object {
        const val MY_PREFERENCE = "my_preferences"
        const val PREF_NAME = "userName"
        const val PREF_PHONE_NUMBER = "phoneNumber"

        private var instance: MyPreferences? = null
        fun getInstance(context: Context): MyPreferences {
            if (instance == null) {
                instance = MyPreferences(context)
            }
            return instance as MyPreferences
        }

    }

    fun saveUserName(userName: String) {
        with(sharedPref.edit()) {
            putString(PREF_NAME, userName)
                .apply()
        }
    }

    fun getUserName(): String? = sharedPref.getString(PREF_NAME, null)

    fun savePhoneNumber(phoneNumber: String) {
        with(sharedPref.edit()) {
            putString(PREF_PHONE_NUMBER, phoneNumber)
                .apply()
        }
    }

    fun getPhoneNumber(): String? = sharedPref.getString(PREF_PHONE_NUMBER, null)
}