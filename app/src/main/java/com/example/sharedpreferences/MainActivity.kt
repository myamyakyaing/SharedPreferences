package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var prefs: MyPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = MyPreferences.getInstance(this)
        btnSave.setOnClickListener {
            prefs.saveUserName(edtUser.text.toString())
            prefs.savePhoneNumber(edtPhone.text.toString())

        }
        btnClear.setOnClickListener {
            edtUser.text.clear()
            edtPhone.text.clear()

        }
        btnRetrieve.setOnClickListener {
            edtUser.setText(prefs.getUserName())
            edtPhone.setText(prefs.getPhoneNumber())

        }
    }
}
