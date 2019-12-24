package com.android.countrycodeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private var phoneNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val typface = ResourcesCompat.getFont(this, R.font.roboto_bold)
        ccpPhoneNumber.setTypeFace(typface)

        ccpPhoneNumber.setOnCountryChangeListener {
            Log.d("selected country code", "${ccpPhoneNumber.selectedCountryCode}")
        }

        edtPhoneNumber.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                text?.let {
                    if (it.startsWith("0")) {
                        if (it.isNotEmpty()) {
                            edtPhoneNumber.setText(it.substring(1))
                        } else {
                            edtPhoneNumber.setText("")
                        }
                    }
                }
            }

        })

        btnSubmit.setOnClickListener {
            phoneNumber = "${ccpPhoneNumber.selectedCountryCode}" + edtPhoneNumber.text.toString()
            Toast.makeText(this, "Your phone number $phoneNumber", Toast.LENGTH_SHORT).show()
        }

    }
}
