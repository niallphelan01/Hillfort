package org.wit.assignment1_hillfort.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.isEmpty
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import org.wit.assignment1_hillfort.R
import org.wit.assignment1_hillfort.main.MainApp
import org.wit.assignment1_hillfort.models.UsersModel


class LoginActivity : AppCompatActivity() {

    private var user = UsersModel()
    lateinit var app: MainApp
    var loggedinUser = UsersModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

      app = application as MainApp
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
          if (user_name != null) {
            user.email = user_name
          }
          user.password = password
          loggedinUser = app.users.findUsers(user.copy())!!


            //add logic to allow for null or then the specific user
            startActivity(Intent(this,HillfortListActivity::class.java)) //start the hillfort activity if username and password match
            finish()
            }
        }


    btnReset.setOnClickListener{ //Rest values entered into the screen in case of errors
        password.setText("")
        user_name.setText("")
    }

        btnSignup.setOnClickListener{
            user.email = "test3"
            user.password = "test3"
            user.userlevel="basic3"
            app.users.createUsers(user.copy())


        }
    }




}