package com.miteris.recaptcha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.safetynet.SafetyNet
import com.google.android.gms.safetynet.SafetyNetClient
import kotlinx.android.synthetic.main.activity_main.*
import com.github.kittinunf.fuel.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myClient: SafetyNetClient = SafetyNet.getClient(this)

        are_you_human_button.setOnClickListener {
            myClient
                .verifyWithRecaptcha(resources.getString(R.string.my_site_key))
                .addOnSuccessListener { successEvent ->
                    val token: String? = successEvent.tokenResult
                    val serverURL: String = "http://127.0.0.1:8000/validate"
                    serverURL.httpGet(listOf("user_token" to token))
                        .responseString { request, response, result ->
                            result.fold({ data ->
                                if(data.contains("PASS"))
                                    Toast.makeText(baseContext,
                                        "You seem to be a human.",
                                        Toast.LENGTH_LONG).show()
                                else
                                    Toast.makeText(baseContext,
                                        "You seem to be a bot!",
                                        Toast.LENGTH_LONG).show()
                            }, { error ->
                                Log.d("ERROR", "Error connecting to the server")
                            })
                        }
                }
        }
    }
}