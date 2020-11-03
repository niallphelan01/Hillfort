package org.wit.assignment1_hillfort.activities

import org.wit.assignment1_hillfort.activities.HillfortListActivity



import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import org.wit.assignment1_hillfort.R
import org.wit.assignment1_hillfort.main.MainApp
import org.wit.assignment1_hillfort.models.UsersModel
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import java.util.*

class LoginActivity : AppCompatActivity() {

    private var user = UsersModel()
    lateinit var app: MainApp
    var loggedinUser: UsersModel? = UsersModel()

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
          loggedinUser = this.app.users.findUsers(user.copy())


          if (loggedinUser?.email  == user_name){
           //add logic to allow for null or then the specific user
            startActivity(Intent(this, HillfortListActivity::class.java)) //start the hillfort activity if username and password match
            finish()}
          else{
            toast("username or email not found")
           }
          }




        }


    btnReset.setOnClickListener{ //Rest values entered into the screen in case of errors
        password.setText("")
        user_name.setText("")
    }

        btnSignup.setOnClickListener{
          if (isEmpty(user_name.text.toString())) {
            toast("Enter username")
          }
          else if (isEmpty(password.text.toString())) {
            toast("Enter password please ")
          }

         // TODO("Maybe add feature to check for email type...@test.com input validation")
             user.email= user_name.text.toString()
             user.password = password.text.toString()
            user.userlevel="basic"
            app.users.createUsers(user.copy())

          toast("the user has been created now enter and submit to proceed")


        }
    }




}