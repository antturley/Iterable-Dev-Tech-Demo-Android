package com.test.iterabledevdemo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.iterable.iterableapi.IterableApi
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSendRequest = findViewById<Button>(R.id.BtnSend)
        btnSendRequest.setOnClickListener{

            Log.w("Button_Press",  "View is active and Payload prepared")
            var profile = JSONObject()
            var datafields = JSONObject()
            try {
                profile.put("firstName", "Anthony")
                profile.put("isRegisteredUser", "true")
                profile.put("SA_User_Test_Key", "completed")

                datafields.put("dataFields", profile)

                Toast.makeText(this@MainActivity, "I ran the code!", Toast.LENGTH_SHORT).show()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            try {
                IterableApi.getInstance().updateUser(datafields)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }



        val btnReceiveRq = findViewById<Button>(R.id.BtnReceive)
        btnReceiveRq.setOnClickListener{
            var customEvent = JSONObject()
            var dataFields = JSONObject()

            dataFields.put("platform","Android")
            dataFields.put("isTestEvent","true")
            dataFields.put("url","https://iterable.com/sa-test/Anthony")
            dataFields.put("secret_code_key","Code_123")



            IterableApi.getInstance().track("mobileSATestEvent!",   dataFields)
        }
    }
}