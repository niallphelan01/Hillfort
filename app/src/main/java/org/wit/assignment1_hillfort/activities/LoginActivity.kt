package org.wit.assignment1_hillfort.activities

import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import org.wit.assignment1_hillfort.R

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    btnSubmit.setOnClickListener{
        val user_name:String? = user_name.text.toString()
        val password = password.text.toString()
        if (isEmpty(user_name)) {
            toast("Enter username")
        }
           else if (isEmpty(password)) {
            toast("Enter password please ")
        }
          else{
                //now check for username and password in the memory and open hillfort activity

            }
        }


    btnReset.setOnClickListener{ //Rest values entered into the screen in case of errors
        password.setText("")
        user_name.setText("")
    }
    }




}