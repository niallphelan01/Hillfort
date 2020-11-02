package org.wit.assignment1_hillfort.activities

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.wit.assignment1_hillfort.R

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //var password = findViewById(R.id.password) as EditText

    btnReset.setOnClickListener{
        password.setText("")
        user_name.setText("")
    }
    }


}